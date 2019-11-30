package com.currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@SpringBootApplication(scanBasePackages = {"com.currency"})
@EnableFeignClients("com.currency.feign.proxy")
@EnableDiscoveryClient
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
