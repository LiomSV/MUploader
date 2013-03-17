package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.service.LikeAndViewsService;

@Controller
public class LikeAndViewsController {
	@Autowired
	private LikeAndViewsService service;

	public void setService(LikeAndViewsService service) {
		this.service = service;
	}
	
	@RequestMapping(value="isliked/{idTrack}")
	public String isLiked(Model model, HttpServletRequest request, @PathVariable Integer idTrack){					    
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return service.isLiked(idTrack, username).toString();
	}
	
	@RequestMapping(value="like/{idTrack}")
	public String like(Model model, HttpServletRequest request, @PathVariable Integer idTrack){					    
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		service.like(idTrack, username);
		return "true";
	}
	
	
	
	@RequestMapping(value="view/{idTrack}")
	public String view(Model model, HttpServletRequest request, @PathVariable Integer idTrack){					    
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		service.view(idTrack, username);	
		return "true";
	}
	
}
