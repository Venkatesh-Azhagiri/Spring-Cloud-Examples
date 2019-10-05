package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

}

@RefreshScope
@RestController
class SpringCloudClientConfigProp{
	
	@Value("${test1:Default value1}")
	private String prop;
	
	 @Value("${spring.cloud.config.uri}")
	 String url;
	 
	// @Value("${profiles}") 
	 String profile;
	 
	 
	@RequestMapping(value="/prop")
	public String getConfigProps(){
		return this.prop+"::url::"+url+"::profile::"+profile;
		
	}
	
	
}
