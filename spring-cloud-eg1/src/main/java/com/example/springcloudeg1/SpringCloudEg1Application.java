package com.example.springcloudeg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudEg1Application {

	public static void main(String[] args) {
		//Example
		//localhost:8888/config-service/dev
		System.out.println("use the property file name as context followed by env*****");
		SpringApplication.run(SpringCloudEg1Application.class, args);
	}

}
