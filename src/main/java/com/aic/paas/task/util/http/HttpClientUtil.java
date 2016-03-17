package com.aic.paas.task.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.aic.paas.task.dev.bean.base.BaseRequest;
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
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     * @throws Exception 
     */
    public static String sendGet(String url, String param) throws Exception {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	throw e;
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
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
        	 HttpPut httpput = new HttpPut(new URL(url).toURI());
             StringEntity  dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
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

