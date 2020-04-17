package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.example.controller"} )
@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
