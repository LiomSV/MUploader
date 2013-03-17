package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Event;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private Criteria criteria(){
		return currentSession().createCriteria(Event.class);
	}
	
	@Override
	public void save(Event event) {
		currentSession().save(event);
	}	

	@Override
	public List<Event> getEvents(Track track, User user, Integer code) {
		 return (List<Event>) criteria()
				.add(Restrictions.like("code", code))
				.add(Restrictions.like("track", track))
				.add(Restrictions.like("user",user))
				.list();
	}
	
	@Override
	public void unlike(Track track, User user) {
		Event like = getEvents(track, user, Event.CODE_LIKE).get(0);
		currentSession().delete(like);
	}

	@Override
	public boolean isLiked(Track track, User user) {
		List<?> list = getEvents(track, user, Event.CODE_LIKE);
		return list.size() > 0 ? true : false;
	}

	@Override
	public List<Event> getAllEvents(User user, Integer code) {
		return (List<Event>) criteria()
				.add(Restrictions.like("code", code))
				.add(Restrictions.like("user", user))
				.list();
	}

}
