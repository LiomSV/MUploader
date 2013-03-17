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
import org.vsp.mup.helper.TrackInfo;

@Service
public class LikeAndViewsService {
	public static final int LIKE = 1;
	public static final int DISLIKE = -1;
	
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
	
	/**
	 * Returns likes count.
	 * @param idTrack
	 * @param username
	 * @return
	 */
	@Transactional
	public void like(Integer idTrack, String username, TrackInfo trackInfo){
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);		
		if (eventDAO.isLiked(track, user)){
			trackInfo.setLikes(decLike(track, user));
			trackInfo.setLiked(false);
		} else { 
			trackInfo.setLikes(incLike(track, user));
			trackInfo.setLiked(true);
		}
	}
	
	private Integer incLike(Track track, User user){
		eventDAO.save(new Event(Event.CODE_LIKE, track, user));
		track.setRating(track.getRating()+1);
		trackDAO.update(track);
		return track.getRating();
	}
	
	private Integer decLike(Track track, User user){
		eventDAO.unlike(track, user);
		track.setRating(track.getRating()-1);
		trackDAO.update(track);
		return track.getRating();
	}
	
	@Transactional
	public Integer view(Integer idTrack, String username){
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);
		return incView(track, user);
	}
	
	private Integer incView(Track track, User user){
		eventDAO.save(new Event(Event.CODE_VIEW, track, user));
		track.setViews(track.getViews()+1);
		trackDAO.update(track);
		return track.getViews();
	}
	
	@Transactional
	public boolean isLiked(Integer idTrack, String username) {
		User user = userDAO.getUserByUsername(username);
		Track track = trackDAO.getTrackById(idTrack);
		return eventDAO.isLiked(track, user);
	}
}
