package com.currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.currency"})
@EnableFeignClients("com.currency.feign.proxy")
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}

}
