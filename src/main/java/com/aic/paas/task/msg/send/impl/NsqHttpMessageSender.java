package com.aic.paas.task.msg.send.impl;

import java.io.InputStream;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aic.paas.task.msg.send.MsgEntity;
import com.binary.core.io.FileSystem;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;
import com.binary.json.JSON;

public class NsqHttpMessageSender extends AbstractMessageSender {
	private static Logger logger = LoggerFactory.getLogger(NsqHttpMessageSender.class);
	
	
	private String nsqRoot;
	
	
	private String nsqHost;
	private Integer nsqPort;
	
	
	public String getNsqRoot() {
		if(BinaryUtils.isEmpty(this.nsqRoot)) {
			if(BinaryUtils.isEmpty(this.nsqHost)) throw new ServiceException(" not set property 'nsqHost'! ");
			if(BinaryUtils.isEmpty(this.nsqPort)) throw new ServiceException(" not set property 'nsqPort'! ");
			this.nsqRoot = "http://"+this.nsqHost+":"+this.nsqPort;
		}
		return nsqRoot;
	}
	

	public String getNsqHost() {
		return nsqHost;
	}
	public void setNsqHost(String nsqHost) {
		this.nsqHost = nsqHost;
	}
	public Integer getNsqPort() {
		return nsqPort;
	}
	public void setNsqPort(Integer nsqPort) {
		this.nsqPort = nsqPort;
	}
	
	
	


	@Override
	protected boolean sendMsg(MsgEntity msg) throws Throwable {
		Throwable tx = null;
		try {
			put(msg);
		}catch(Throwable t) {
			tx = t;
		}
		logger.info(" send msg to message queue ["+(tx==null?"OK":"ERROR")+"]: "+JSON.toString(msg));
		if(tx != null) {
			logger.error("ERROR", tx);
		}
		
		return tx == null;
	}
	
	
	
	
	
	
	
	
	private void put(MsgEntity msg) throws Throwable {
		String url = getNsqRoot()+"/put?topic="+msg.getType().toLowerCase();
		request(url, msg);
	}
	
	
	
	
	
	private void request(String url, MsgEntity msg) throws Throwable {
		String data = JSON.toString(msg);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(new URL(url).toURI());
        StringEntity dataEntity = new StringEntity(data, ContentType.APPLICATION_JSON);
        httpPost.setEntity(dataEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);
		
        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                
                InputStream is = null;
                try {
                	String rs = FileSystem.read(entity.getContent(), "UTF-8");
                	if(!rs.equals("OK")) {
                		throw new RuntimeException(rs);
                	}
                }finally {
                	if(is != null) is.close();
                }
            } else {
                throw new RuntimeException("error code " + response.getStatusLine().getStatusCode()
                        + ":" + response.getStatusLine().getReasonPhrase());
            }
        } finally {
            response.close();
            httpclient.close();
        }
	}
	
	
	

}