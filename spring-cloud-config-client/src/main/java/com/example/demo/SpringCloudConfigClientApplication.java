package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableHystrix
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		//http://localhost:7777/prop
		//will refresh only one instance
		//POST: http://localhost:7777/actuator/refresh
		//Will refresh all instance
		//POST: http://localhost:7777/actuator/bus-refresh
		
		//Hystrix
		//http://localhost:7777/propHystrix
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
	
	@GetMapping(value="/propHystrix")
	@HystrixCommand(fallbackMethod = "fallBackHystrix")
	public String getConfigPropsHystrix(){
		//return this.prop+"::url::"+url+"::profile::"+profile;
		throw new RuntimeException("Fault Tolerance");		
	}
	
	public String fallBackHystrix(){
		return "This is default hystrix fault tolerance method";
		
	}
	
	
}

