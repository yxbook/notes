package com.iamlook;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
=======
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@MapperScan("com.iamlook.mapper")
>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa
public class IamBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamBookApplication.class, args);
	}
}
