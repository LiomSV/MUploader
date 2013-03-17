package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vsp.mup.helper.TrackInfo;
import org.vsp.mup.service.LikeAndViewsService;

@Controller
public class LikeAndViewsController {
	@Autowired
	private LikeAndViewsService service;

	public void setService(LikeAndViewsService service) {
		this.service = service;
	}
	
	@RequestMapping(value="like/{idTrack}",  method = RequestMethod.GET)
	public @ResponseBody TrackInfo like(Model model, HttpServletRequest request, @PathVariable Integer idTrack){					    
		TrackInfo trackInfo = new TrackInfo();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		service.like(idTrack, username, trackInfo);		
		return trackInfo;
	}
	
	
	@RequestMapping(value="view/{idTrack}")
	public @ResponseBody TrackInfo view(Model model, HttpServletRequest request, @PathVariable Integer idTrack){					    
		TrackInfo trackInfo = new TrackInfo();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		trackInfo.setViews(service.view(idTrack, username));
		return trackInfo;
	}
	
	
	@RequestMapping(value="isliked/{idTrack}", method = RequestMethod.GET)
	public @ResponseBody TrackInfo isLiked(@PathVariable Integer idTrack) {
		TrackInfo trackInfo = new TrackInfo();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		trackInfo.setLiked(service.isLiked(idTrack, username)); 
		return trackInfo;
	}
}
