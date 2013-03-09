package org.vsp.mup.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;

import javax.mail.MessagingException;
import javax.mail.internet.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	@RequestMapping(value = "addUser")
	public String registration() throws MessagingException {
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
	    sender.setPort(587);
	    sender.setUsername("musicuploadervs@gmail.com");
	    sender.setPassword("music_187");
	    
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo("lio@biz.by");
		helper.setText("Thank you for ordering!");

		SimpleMailMessage simple = new SimpleMailMessage();
		simple.setTo("lio@biz.by");
		simple.setText("Hello! Yeah!!!");
		
		sender.send(simple);
		
		return "registration";
	}
		
	
}
