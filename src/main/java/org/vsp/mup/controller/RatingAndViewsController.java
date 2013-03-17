package org.vsp.mup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;
import org.vsp.mup.service.PlaylistService;
import org.vsp.mup.service.RatingAndViewsService;

@Controller
public class RatingAndViewsController {
	@Autowired
	private RatingAndViewsService service;

	public void setService(RatingAndViewsService service) {
		this.service = service;
	}
	
	@Autowired
	private PlaylistService playlistService;
	
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	private String getUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@RequestMapping(value = "rating")
	public String rating(){
		return "redirect:/rating/1";
	}
	
	@RequestMapping(value = "rating/{page}")
	public String ratingPage(Model model, HttpServletRequest request, @PathVariable Integer page){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("message", "rating");
		model.addAttribute(page);
		List<Track> trackList = service.getTracksByRating();
		model.addAttribute("trackList", service.getTracksForPage(trackList, page));
		model.addAttribute("pages", service.getPagesQuantity(trackList.size()));	
		model.addAttribute("lists", playlistService.getPlaylistsByUsername(getUsername()));
		return "ratingOrViews";
	}
	
	@RequestMapping(value = "views")
	public String views(){
		return "redirect:/views/1";
	}
	
	@RequestMapping(value = "views/{page}")
	public String views(Model model, HttpServletRequest request, @PathVariable Integer page){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("message", "views");
		model.addAttribute(page);
		List<Track> trackList = service.getTracksByViews();
		model.addAttribute("trackList", service.getTracksForPage(trackList, page));
		model.addAttribute("pages", service.getPagesQuantity(trackList.size()));	
		model.addAttribute("lists", playlistService.getPlaylistsByUsername(getUsername()));
		return "ratingOrViews";
	}
	
}
