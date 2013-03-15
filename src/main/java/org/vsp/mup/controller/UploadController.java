package org.vsp.mup.controller;

import java.io.File;
import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.vsp.mup.domain.Track;
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
		return "upload";
	}
	
	
	@RequestMapping(value = "/upload/info")
	public String songEdit(Model model, HttpServletRequest request, @ModelAttribute("uploadForm") MultipartFile uploadForm){				
		model.addAttribute("path", request.getRequestURI());
		this.uploadForm = uploadForm;
		return "uploadInfo";
	}
	
	@RequestMapping(value = "/upload/view")
	public String songEditView(Model model, HttpServletRequest request, @ModelAttribute("track") Track track, @ModelAttribute("artistName") String artistName, @ModelAttribute("tagLine") String tagLine){				
		model.addAttribute("path", request.getRequestURI());		
		trackUploadService.initiateTrack(track);
		model.addAttribute(track);		
		model.addAttribute(artistName);
		model.addAttribute(tagLine);		
		this.track = track;
		this.artistName = artistName;
		this.tagLine = tagLine;
		return "uploadView";
	}
	
	@RequestMapping(value = "/upload/done")
	public String done(Model model, HttpServletRequest request){
		if (track != null){
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			trackUploadService.addNewTrack(track, artistName, tagLine, username, uploadForm);
		} else {
			model.addAttribute("error", true);
		}
		return "uploadDone";
	}
	
	@RequestMapping(value = "/upload/cancel")
	public String cancel(){
		track = null;
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/upload/test")
	public String test(Model model, @ModelAttribute("list") String files){
		model.addAttribute("a" , true);
		if (files != null){
			model.addAttribute("b" , true);
			File file = new File("d:\\aaa.jpg");
			try{
				FileUtils.writeByteArrayToFile(file, files.getBytes());
			} catch (Throwable e){
				e.printStackTrace();
			}
		}		
		return "uploadInfo";
	}
	
	private Track track = null;
	private String artistName = "", tagLine = "";
	private MultipartFile uploadForm;
}
