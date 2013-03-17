package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.service.PlaylistService;
import org.vsp.mup.service.TagPageService;

@Controller
public class TagController {
	@Autowired
	private TagPageService tagPageService;
	
	public void setTagPageService(TagPageService tagPageService) {
		this.tagPageService = tagPageService;
	}
	
	@Autowired
	private PlaylistService playlistService;
	
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	private String getUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@RequestMapping(value = "tag/{idTag}")
	public String tag(@PathVariable Integer idTag){
		return "redirect:/tag/" + idTag + "/1";
	}
	
	@RequestMapping(value = "tag/{idTag}/{page}")
	public String tagPage(Model model, @PathVariable Integer idTag, @PathVariable Integer page, HttpServletRequest request){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute(page);
		Tag tag = tagPageService.getTagWithTracks(idTag);
		model.addAttribute(tag);
		model.addAttribute("pages", tagPageService.getPagesQuantity(tag));
		model.addAttribute("trackList", tagPageService.getTracksForPage(tag, page));
		model.addAttribute("lists", playlistService.getPlaylistsByUsername(getUsername()));
		return "tag";
	}
}
