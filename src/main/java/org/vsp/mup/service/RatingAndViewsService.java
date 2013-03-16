package org.vsp.mup.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;

@Service
public class RatingAndViewsService {
	public static final int TRACKS_ON_PAGE = 9;
	
	@Autowired
	private TrackDAO trackDAO;

	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	public Integer getPagesQuantity(Integer size){
		return (size+TRACKS_ON_PAGE-1)/TRACKS_ON_PAGE;
	}
	
	public List<Track> getTracksForPage(List<Track> allTracks, Integer page){
		List<Track> trackList = new ArrayList<Track>();
		for(int i = 0; (i < allTracks.size()) && (i < TRACKS_ON_PAGE); ++i){
			trackList.add(allTracks.get((page-1)*TRACKS_ON_PAGE+i));
		}
		return trackList;
	}
	
	@Transactional
	public List<Track> getTracksByRating(){
		List<Track> trackList = trackDAO.getTracksByRating();
		for(Track track : trackList){
			Hibernate.initialize(track.getArtist());
			Hibernate.initialize(track.getTags());
		}
		return trackList;
	}
	
	@Transactional
	public List<Track> getTracksByViews(){
		List<Track> trackList = trackDAO.getTracksByViews();
		for(Track track : trackList){
			Hibernate.initialize(track.getArtist());
			Hibernate.initialize(track.getTags());
		}
		return trackList;
	}
	
}
