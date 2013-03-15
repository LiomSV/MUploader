package org.vsp.mup.controller;

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
import org.vsp.mup.service.UploadedFile;
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
		model.addAttribute(track);		
		model.addAttribute("artistName",artistName);
		model.addAttribute("tagLine" ,tagLine);
		return "uploadInfo";
	}
	
	@RequestMapping(value = "/upload/view")
	public String songEditView(Model model, HttpServletRequest request, @ModelAttribute("track") Track track, @ModelAttribute("artistName") String artistName, @ModelAttribute("tagLine") String tagLine){				
		if ((track.getTitle() == null) || (track.getTitle() == "") || (artistName == null) || (artistName == ""))
			return "redirect:/upload/info?error=true";
		model.addAttribute("path", request.getRequestURI());	
		model.addAttribute("headerUpload", true);
		trackUploadService.initiateTrack(track);
		model.addAttribute(track);		
		model.addAttribute("artistName",artistName);
		model.addAttribute("tagLine" ,tagLine);	
		this.track = track;
		this.artistName = artistName;
		this.tagLine = tagLine;
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
		trackUploadService.saveToFile(uploadedFile);
	}
	
	private Track track = new Track();
	private String artistName = "", tagLine = "";
}
