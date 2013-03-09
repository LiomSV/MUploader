package org.vsp.mup.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.domain.User;
import org.vsp.mup.service.UserActivator;

@Controller
public class RegistrationController {
	@RequestMapping(value = "addUser")
	public String registration(){
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("classpath:Spring-Mail.xml");
		UserActivator activator = (UserActivator) context.getBean("userActivator");
		
		activator.activateUser(new User());
		
		
		
		return "registration";
	}
		
	
}
