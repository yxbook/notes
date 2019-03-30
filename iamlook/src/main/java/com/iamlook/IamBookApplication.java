package com.iamlook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@MapperScan("com.iamlook.mapper")
public class IamBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamBookApplication.class, args);
	}
}
