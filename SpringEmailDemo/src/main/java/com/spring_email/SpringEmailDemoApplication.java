package com.spring_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class SpringEmailDemoApplication {
	@Autowired
	SenderEmailService ses;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);
	}

	
	@EventListener(ApplicationReadyEvent.class)	
	public void sendMail() {
		ses.mail("shri24041996@gmail.com",//receiver email id
				"check the project code",
				"this is body");

	}
}
