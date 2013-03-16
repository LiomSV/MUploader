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
	public boolean isLiked(Track track, User user) {
		List<?> list = criteria()
				.add(Restrictions.like("code", CODE_LIKE))
				.add(Restrictions.like("track", track))
				.add(Restrictions.like("user",user))
				.list();
		return list.size() > 0 ? true : false;
	}

	@Override
	public List<Event> getLikes(User user) {
		return (List<Event>) criteria()
				.add(Restrictions.like("code", CODE_LIKE))
				.add(Restrictions.like("user", user))
				.list();
	}

	@Override
	public List<Event> getViews(User user) {
		return (List<Event>) criteria()
				.add(Restrictions.like("code", CODE_VIEW))
				.add(Restrictions.like("user",user))
				.list();
	}

}
