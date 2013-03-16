package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.service.ProfileService;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService service;

	public void setService(ProfileService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "user")
	public String user(Model model, HttpServletRequest request){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Integer idUser = service.getIdUser(username);
		return "redirect:/user/" + idUser;
	}
	
	@RequestMapping(value = "user/{idUser}")
	public String anyUser(Model model, HttpServletRequest request, @PathVariable Integer idUser){
		return "redirect:/user/" + idUser + "/like";
	}
	
	@RequestMapping(value = "user/{idUser}/like")
	public String userLike(Model model, HttpServletRequest request, @PathVariable Integer idUser){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("sort", "like");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();	
		model.addAttribute("username", username);
		model.addAttribute("data", service.getLikes(username));
		return "user";
	}
	
	@RequestMapping(value = "user/{idUser}/views")
	public String userViews(Model model, HttpServletRequest request, @PathVariable Integer idUser){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("sort", "views");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();	
		model.addAttribute("username", username);
		model.addAttribute("data", service.getViews(username));
		return "user";
	}
}
