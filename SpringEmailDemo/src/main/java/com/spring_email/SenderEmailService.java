package com.spring_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderEmailService {
	@Autowired
	JavaMailSender jms;

	public void mail(String email, String subject, String body) {

		SimpleMailMessage sem = new SimpleMailMessage();
		sem.setFrom("akashsable576@gmail.com"); // sender email id
		sem.setTo(email);
		sem.setText(body);
		sem.setSubject(subject);

		jms.send(sem);

		System.out.println("Email send Secussefully");
	}
}
