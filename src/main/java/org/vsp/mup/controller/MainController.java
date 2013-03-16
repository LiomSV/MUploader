package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.helper.DateFormatTransformer;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.vsp.mup.service.HomeService;

@Controller
public class MainController {
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private DateFormatTransformer dateFormatTransformer;
	
	public void setHomeService(HomeService homeService){
		this.homeService = homeService;
	}	
	
	public void setDateFormatTransformer(DateFormatTransformer dateFormatTransformer) {
		this.dateFormatTransformer = dateFormatTransformer;
	}

	@RequestMapping(value = "/")
	public String main(Model model, HttpServletRequest request){				
		return "redirect:/home";
	}
	
	@RequestMapping(value = "home")
	public String home(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("trackList", homeService.getLastTracks());
		model.addAttribute(dateFormatTransformer);
		model.addAttribute("tagList", homeService.getPopularTags());
		return "home";
	}
	
	@RequestMapping(value = "home/updateCloud")
	public String updateCloud(Model model, HttpServletRequest request){				
		homeService.updateTagsPopularity();		
		return "redirect:/home";
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