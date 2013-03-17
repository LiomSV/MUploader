package org.vsp.mup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.EventDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Event;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

@Service
public class LikeAndViewsService {
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private TrackDAO trackDAO;

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}
	
	@Transactional
	public void like(Integer idTrack, String username){
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);		
		if (eventDAO.isLiked(track, user)){
			decLike(track, user);
		} else { 
			incLike(track, user); 
		}
	}
	
	private void incLike(Track track, User user){
		eventDAO.save(new Event(Event.CODE_LIKE, track, user));
		track.setRating(track.getRating()+1);
		trackDAO.update(track);
	}
	
	private void decLike(Track track, User user){
		eventDAO.unlike(track, user);
		track.setRating(track.getRating()-1);
		trackDAO.update(track);
	}
	
	@Transactional
	public void view(Integer idTrack, String username){
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);
		incView(track, user);
	}
	
	private void incView(Track track, User user){
		eventDAO.save(new Event(Event.CODE_VIEW, track, user));
		track.setViews(track.getViews()+1);
		trackDAO.update(track);
	}
	
	@Transactional
	public Boolean isLiked(Integer idTrack, String username) {
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);
		return eventDAO.isLiked(track, user);
	}
}
