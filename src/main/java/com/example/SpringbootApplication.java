package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.example.dao")
public class SpringbootApplication {
	@RequestMapping("/test")    
	 String test() {
	    return "Hello World!";
	 }   
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
