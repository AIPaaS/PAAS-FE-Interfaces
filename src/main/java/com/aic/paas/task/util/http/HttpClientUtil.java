package com.aic.paas.task.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.aic.paas.task.mvc.dev.bean.base.BaseRequest;
import com.binary.json.JSON;

public class HttpClientUtil {
	
    private static final Log logger = LogFactory.getLog(HttpClientUtil.class);

    /**
     * sendPostRequest:http post请求调用方法 <br/>    
     * 在调用出现异常时，返回“error”,用以判断请求链完成情况
     *
     * @author archer
     * @param url
     * @param param
     * @return
     */
    public static String sendPostRequest(String url, String param)  {
    	logger.info("url :" + url);
    	logger.info("param contents:" + param);
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	StringBuffer buffer = new StringBuffer();
        try {
        	 httpclient = HttpClients.createDefault();        	 
        	 HttpPostWithBody httpPost = new HttpPostWithBody(new URL(url).toURI());
             StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
             httpPost.setEntity(dataEntity);
             response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));                
                String tempStr;
                while ((tempStr = reader.readLine()) != null){
                    buffer.append(tempStr);
                }
                logger.info("response contents:" + buffer.toString());
            } 
            else {
            	throw new RuntimeException("error code " + response.getStatusLine().getStatusCode()
                        + ":" + response.getStatusLine().getReasonPhrase());
            }
        }catch(Exception e){        	
        	logger.error(e.getMessage(),e);
        	return "error";
        } finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
	        	return "error";
			}
        }
        return buffer.toString();

    }
    
    /**
     * HTTP GET请求
     * @param url
     * @param param
     * @return
     */
    public static String sendGetRequest(String url, String param)  {
    	logger.info("url :" + url);
    	logger.info("param contents:" + param);
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	StringBuffer buffer = new StringBuffer();
        try {
        	 httpclient = HttpClients.createDefault();        	 
        	 HttpGetWithBody httpGet = new HttpGetWithBody(new URL(url).toURI());
             StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
             httpGet.setEntity(dataEntity);
             response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));                
                String tempStr;
                while ((tempStr = reader.readLine()) != null){
                    buffer.append(tempStr);
                }
                logger.info("response contents:" + buffer.toString());
            } 
            else {
            	throw new RuntimeException("error code " + response.getStatusLine().getStatusCode()
                        + ":" + response.getStatusLine().getReasonPhrase());
            }
        }catch(Exception e){        	
        	logger.error(e.getMessage(),e);
        	return "error";
        } finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
	        	return "error";
			}
        }
        return buffer.toString();

    }
    
    
    /**
     * sendPostRequest:http post请求调用方法 <br/>    
     * 在调用出现异常时，返回“error”,用以判断请求链完成情况
     *
     * @author archer
     * @param url
     * @param param
     * @return
     */
    public static String sendPutRequest(String url, String param)  {
    	logger.info("url :" + url);
    	logger.info("param contents:" + param);
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	StringBuffer buffer = new StringBuffer();
        try {
        	 httpclient = HttpClients.createDefault();        	 
        	 HttpPutWithBody httpput = new HttpPutWithBody(new URL(url).toURI());
             StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
             httpput.setEntity(dataEntity);
             response = httpclient.execute(httpput);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));                
                String tempStr;
                while ((tempStr = reader.readLine()) != null){
                    buffer.append(tempStr);
                }
                logger.info("response contents:" + buffer.toString());
            } 
            else {
            	throw new RuntimeException("error code " + response.getStatusLine().getStatusCode()
                        + ":" + response.getStatusLine().getReasonPhrase());
            }
        }catch(Exception e){        	
        	logger.error(e.getMessage(),e);
        	return "error";
        } finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
	        	return "error";
			}
        }
        return buffer.toString();

    }
    
    
    /**
     * sendPostRequest:http post请求调用方法 <br/>    
     * 在调用出现异常时，返回“error”,用以判断请求链完成情况
     *
     * @author archer
     * @param url
     * @param param
     * @return
     */
    public static String sendDeleteRequest(String url, String param)  {
    	logger.info("url :" + url);
    	logger.info("param contents:" + param);
    	CloseableHttpClient httpclient = null;
    	CloseableHttpResponse response = null;
    	StringBuffer buffer = new StringBuffer();
        try {
        	 httpclient = HttpClients.createDefault();        	 
        	 HttpEntityEnclosingRequestBase httpDelete = new HttpDeleteWithBody(new URL(url).toURI());
             StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
             httpDelete.setEntity(dataEntity);
             response = httpclient.execute(httpDelete);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));                
                String tempStr;
                while ((tempStr = reader.readLine()) != null){
                    buffer.append(tempStr);
                }
                logger.info("response contents:" + buffer.toString());
            } 
            else {
            	throw new RuntimeException("error code " + response.getStatusLine().getStatusCode()
                        + ":" + response.getStatusLine().getReasonPhrase());
            }
        }catch(Exception e){        	
        	logger.error(e.getMessage(),e);
        	return "error";
        } finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
	        	return "error";
			}
        }
        return buffer.toString();

    }
        
    
    public static void main(String[] args) {
    	
    	
    	BaseRequest req = new BaseRequest();
    	req.setNamespace("post");
    	String param = JSON.toString(req);
    	System.out.println(param);
       String result = HttpClientUtil.sendPostRequest("http://localhost:16009/paas-task/dev/demoMvc/post", param);
       System.out.println(result);    
    	
    	
    	/*BaseRequest req = new BaseRequest();
    	req.setNamespace("putreq");
    	String param = JSON.toString(req);
    	System.out.println(param);
       String result = HttpClientUtil.sendPostRequest("http://localhost:16009/paas-task/dev/demoMvc/put", param);
       System.out.println(result);   */ 
      
      
    }
}

