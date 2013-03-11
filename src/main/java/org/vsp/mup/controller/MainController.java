package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String main(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		return "home";
	}
	
	@RequestMapping(value = "home")
	public String home(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		return "home";
	}
	
	@RequestMapping(value = "login")
	public String login(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		return "login";
	}	

	@RequestMapping(value = "registration")
	public String registration(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		return "registration";
	}
	
}