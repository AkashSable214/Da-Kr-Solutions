package com.spring_Junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring_Junit")
public class SpringJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJunitApplication.class, args);
	}

}
