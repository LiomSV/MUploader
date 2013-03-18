package org.vsp.mup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.vsp.mup.domain.Track;
import org.vsp.mup.helper.ID3Service;
import org.vsp.mup.helper.UploadedFile;
import org.vsp.mup.service.TrackUploadService;

@Controller
public class UploadController {
	@Autowired
	private TrackUploadService trackUploadService;
	
	public void setTrackUploadService(TrackUploadService trackUploadService) {
		this.trackUploadService = trackUploadService;
	}
	
	@RequestMapping(value = "/upload")
	public String upload(HttpSession httpSession, Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());			
		model.addAttribute("headerUpload", true);
		return "upload";
	}
		
	@RequestMapping(value = "/upload/info")
	public String songEdit(Model model, HttpServletRequest request){				
		model.addAttribute("path", request.getRequestURI());
		model.addAttribute("headerUpload", true);
		model.addAttribute("id3List", id3List);
		return "uploadInfo";
	}
	
	@RequestMapping(value = "/upload/view")
	public String songEditView(Model model, HttpServletRequest request, @ModelAttribute("track") Track track, @ModelAttribute("artistName") String artistName, @ModelAttribute("tagLine") String tagLine){				
		if ((track.getTitle() == null) || (track.getTitle() == "") || (artistName == null) || (artistName == ""))
			return "redirect:/upload/info?error=true";
		model.addAttribute("path", request.getRequestURI());	
		model.addAttribute("headerUpload", true);
		trackUploadService.initiateTrack(track);
		this.track = mergeTracks(this.track, track);
		this.artistName = artistName;
		this.tagLine = tagLine;
		ID3Service.initID3List(id3List, track, artistName);
		model.addAttribute("id3List", id3List);
		return "uploadView";
	}
	
	@RequestMapping(value = "/upload/done")
	public String done(Model model, HttpServletRequest request){
		if (track != null){
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			trackUploadService.addNewTrack(track, artistName, tagLine, username);			
		} else {
			model.addAttribute("error", true);
		}
		return "uploadDone";
	}
	
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(value = "/upload/uploading")
	public void test(Model model, HttpServletRequest request, @ModelAttribute("file") UploadedFile uploadedFile){
		id3List = trackUploadService.saveToFileAndGetID3(uploadedFile, track, SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	private Track track = new Track();
	private String artistName = "", tagLine = "";
	private List<String> id3List;
	
	private Track mergeTracks(Track first, Track second){
		Track track = new Track();
		
		track.setFile(first.getFile());
		track.setUser(first.getUser());
		
		track.setTitle(second.getTitle());
		track.setArtist(second.getArtist());
		track.setGenre(second.getGenre());
		track.setDescription(second.getDescription());
		
		return track;
	}
}
