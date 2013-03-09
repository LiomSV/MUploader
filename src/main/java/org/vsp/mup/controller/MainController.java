package org.vsp.mup.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String main() {
		return "home";
	}
	
	@RequestMapping(value = "home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}	

	@RequestMapping(value = "registration")
	public String registration() {
		return "registration";
	}
	
}