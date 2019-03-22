package com.iamlook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IamBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamBookApplication.class, args);
	}
}
