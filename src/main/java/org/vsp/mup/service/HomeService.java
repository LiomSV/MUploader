package org.vsp.mup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.domain.Track;

@Service
public class HomeService {
	private static final int TRACKS_QUANTITY = 15;
	
	@Autowired
	private TrackDAO trackDAO;

	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	@Transactional
	public List<Track> getLastTracks(){
		return trackDAO.getLastTracks(TRACKS_QUANTITY);
	}
}
