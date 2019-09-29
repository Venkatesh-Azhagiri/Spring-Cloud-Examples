package com.example.springcloudeg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudEg1Application {

	public static void main(String[] args) {
		System.out.println("test*****");
		SpringApplication.run(SpringCloudEg1Application.class, args);
	}

}
