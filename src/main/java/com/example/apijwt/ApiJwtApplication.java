package com.example.apijwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.apijwt.*" })
public class ApiJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJwtApplication.class, args);
	}

}
