package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.service.ArtistPageService;
import org.vsp.mup.service.PlaylistService;

@Controller
public class ArtistController {
	@Autowired
	private ArtistPageService artistPageService;	
	
	public void setArtistPageService(ArtistPageService artistPageService) {
		this.artistPageService = artistPageService;
	}
	
	@Autowired
	private PlaylistService playlistService;
	
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	private String getUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@RequestMapping(value = "artist/{idArtist}/{page}")
	public String artist(Model model, @PathVariable Integer idArtist, @PathVariable Integer page, HttpServletRequest request){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("message", "artist");
		model.addAttribute(page);
		Artist artist = artistPageService.getArtistWithTracks(idArtist);
		model.addAttribute(artist);
		model.addAttribute("pages", artistPageService.getPagesQuantity(artist));
		model.addAttribute("trackList", artistPageService.getTracksForPage(artist, page));
		model.addAttribute("lists", playlistService.getPlaylistsByUsername(getUsername()));
		return "artist";
	}
	
	@RequestMapping(value = "artists")
	public String artists(Model model, HttpServletRequest request){
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("artistList", artistPageService.getSplitedArtistsList());
		return "artists";
	}
}
