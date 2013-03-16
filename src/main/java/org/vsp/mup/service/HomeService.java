package org.vsp.mup.service;

import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.TagDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;
import org.vsp.mup.helper.TagComparator;

@Service
public class HomeService {
	private static final int TRACKS_QUANTITY = 15;
	private static final int TAG_QUANTITY = 25;
	private static final int[] LEVEL_TAG_QUANTITY = {25, 20, 15, 11, 7, 4, 1, 0};
	
	@Autowired
	private TrackDAO trackDAO;

	@Autowired
	private TagDAO tagDAO;
	
	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	
	@Transactional
	public List<Track> getLastTracks(){
		List<Track> trackList = trackDAO.getLastTracks(TRACKS_QUANTITY);
		for(Track t : trackList){
			Hibernate.initialize(t.getTags());
		}
		return trackList;		
	}
	
	@Transactional
	public List<Tag> getPopularTags(){
		List<Tag> tagList = tagDAO.getPopularTags(TAG_QUANTITY);		
		Collections.shuffle(tagList);
		return tagList;				
	}
	
	@Transactional
	public void updateTagsPopularity(){
		List<Tag> tagList = tagDAO.getAllTags();
		countAndSortBySongs(tagList);
		setTagLevel(tagList);
		cleanPopularity(tagList);
		updageTags(tagList);
	}
	
	private void countAndSortBySongs(List<Tag> tagList){
		for(Tag tag : tagList){
			tag.setPopularity(tag.getTracks().size());
		}
		Collections.sort(tagList, new TagComparator<Tag>());
	}
	
	private void setTagLevel(List<Tag> tagList){
		for(int i=0; i < LEVEL_TAG_QUANTITY.length-1; ++i){
			for(int j=LEVEL_TAG_QUANTITY[i]-1; j > LEVEL_TAG_QUANTITY[i+1]-1; --j){
				if (j < tagList.size()){
					tagList.get(j).setPopularity(i+1);
				}
			}
		}
	}
	
	private void cleanPopularity(List<Tag> tagList){
		for(int j=LEVEL_TAG_QUANTITY[0]; j < tagList.size(); ++j){
			tagList.get(j).setPopularity(0);
		}
	}
	
	@Transactional
	private void updageTags(List<Tag> tagList){
		for(Tag tag : tagList){
			tagDAO.upgateTag(tag);
		}
	}
	
}
