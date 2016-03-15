package com.aic.paas.task.test.svc;


public class PcBuildDefMvcTest {
	
	
	public static void main(String[] args) {
		String param="{\"namespace\": \"zhwenh1\",\"repo_name\": \"aaaafw/bbbbc\", \"image_name\": \"tomcat\",\"description\": \"des\",\"is_public\": \"true\"," 
			+"\"email_enabled\": \"false\"," 
    		+"\"email\": \"zhwenhu@163.com\","
    		+"\"build_config\": {"
			+"\"code_repo_client\": \"Gitlab\","
			+"\"code_repo_clone_url\": \"https://github.com/zhwenh/dockerfile-jdk-tomcat.git\"," 
        	+"\"tag_configs\": {"
        	+"\"code_repo_type\": \"branch\", "
            +"\"code_repo_type_value\": \"master\"," 
            +"\"docker_repo_tag\": \"1.0.0\","
            +"\"dockerfile_location\": \"./Dockerfile\","
            +"\"is_active\": \"true\"," 
            +"\"build_cache_enabled\": \"true\""
            +"}"
            +"}"
            +"}";
//		String sendPostRequest = HttpClientUtil.sendPutRequest("http://10.1.245.139:8088/v1/repositories", param);
//		@SuppressWarnings("rawtypes")
//		Map map = JSON.toObject(sendPostRequest, Map.class);
//		System.out.println(map.get("status"));
	}
}
