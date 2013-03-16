package org.vsp.mup.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.EventDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Event;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.helper.TagValueList;

@Service
public class ProfileService {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private EventDAO eventDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
	
	@Transactional
	public TagValueList getLikes(String username){
		TagValueList likes = new TagValueList();
		List<Event> eventList = eventDAO.getLikes(userDAO.getUserByUsername(username));
		parseEventList(eventList, likes);
		return likes;
	}
	
	@Transactional
	public TagValueList getViews(String username){
		TagValueList views = new TagValueList();
		List<Event> eventList = eventDAO.getViews(userDAO.getUserByUsername(username));
		parseEventList(eventList, views);
		return views;
	}
	
	@Transactional
	public Integer getIdUser(String username){
		return userDAO.getUserByUsername(username).getIdUser();
	}
	
	private void parseEventList(List<Event> eventList, TagValueList target){
		for(Event event : eventList){
			Hibernate.initialize(event.getTrack().getTags());
			parseTagSet(event.getTrack().getTags(), target);
		}
	}
	
	private void parseTagSet(Set<Tag> tagSet, TagValueList target){
		for(Tag tag : tagSet){
			target.addTag(tag);
		}
	}
}
