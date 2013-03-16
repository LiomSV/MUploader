package org.vsp.mup.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.TagDAO;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;

@Service
public class TagPageService {
	public static final int TRACKS_ON_PAGE = 9;
	
	@Autowired
	private TagDAO tagDAO;

	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	
	@Transactional
	public Tag getTagWithTracks(Integer idTag){
		Tag tag = tagDAO.getTagById(idTag);
		Hibernate.initialize(tag.getTracks());
		return tag;		
	}
	
	public Integer getPagesQuantity(Tag tag){
		return (tag.getTracks().size()+TRACKS_ON_PAGE-1)/TRACKS_ON_PAGE;
	}
	
	public List<Track> getTracksForPage(Tag tag, Integer page){
		List<Track> trackList = new ArrayList<Track>();
		for(int i = 0; (i < tag.getTracks().size()) && (i < TRACKS_ON_PAGE); ++i){
			trackList.add(tag.getTracks().get((page-1)*TRACKS_ON_PAGE+i));
		}
		return trackList;
	}
	
}
