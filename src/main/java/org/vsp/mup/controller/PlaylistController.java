package org.vsp.mup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vsp.mup.domain.Playlist;
import org.vsp.mup.helper.StringHelper;
import org.vsp.mup.service.PlaylistService;

@Controller
public class PlaylistController {
	@Autowired
	private PlaylistService service;

	public void setService(PlaylistService service) {
		this.service = service;
	}
	
	private String getUsername(){
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@RequestMapping(value = "playlists")
	public String playlists(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());		
		model.addAttribute("playlists", service.getPlaylistsByUsername(getUsername()));		
		return "playlists";
	}
	
	@RequestMapping(value = "playlists/new")
	public String newPlaylist(@ModelAttribute("name") String playlistName){
		service.createPlaylist(getUsername(), playlistName);
		return "redirect:/playlists";
	}
	
	@RequestMapping(value = "playlist/{idPlaylist}")
	public String playlist(Model model, HttpServletRequest request, @PathVariable Integer idPlaylist){				
		model.addAttribute("path", request.getRequestURI());
		Playlist playlist = service.getPlaylist(getUsername(), idPlaylist);
		if (playlist == null)
			return "redirect:/playlists";
		model.addAttribute("playlist", playlist);
		model.addAttribute("files", StringHelper.groupPlaylistFiles(playlist.getTracks()));
		model.addAttribute("titles", StringHelper.groupPlaylistTitles(playlist.getTracks()));
		model.addAttribute("artists", StringHelper.groupPlaylistArtists(playlist.getTracks()));
		return "playlist";
	}
	
	@RequestMapping(value = "add/{idTrack}/{idPlaylist}")
	public @ResponseBody void add(@PathVariable Integer idPlaylist, @PathVariable Integer idTrack){
		service.addTrackToPlaylist(idTrack, idPlaylist);
	}
	
	@RequestMapping(value = "delete/playlist/{idPlaylist}")
	public String playlist(@PathVariable Integer idPlaylist){
		service.deletePlaylist(idPlaylist, getUsername());
		return "redirect:/playlists";
	}
	
}
