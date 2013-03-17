package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Event;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

public interface EventDAO {		
	public void save(Event event);
	
	public List<Event> getEvents(Track track, User user, Integer code);
	
	public void unlike(Track track, User user);
	
	public boolean isLiked(Track track, User user);
	
	public List<Event> getAllEvents(User user, Integer code);
}
