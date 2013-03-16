package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Event;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

public interface EventDAO {
	public static final Integer CODE_LIKE = 1;
	public static final Integer CODE_VIEW = 2;
	
	public void save(Event event);
	public boolean isLiked(Track track, User user);
	public List<Event> getLikes(User user);
	public List<Event> getViews(User user);
}
