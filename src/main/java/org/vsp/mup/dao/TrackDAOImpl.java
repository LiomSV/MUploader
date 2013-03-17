package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

@Repository
public class TrackDAOImpl implements TrackDAO {
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Track getTrackById(Integer id) {
		return (Track) currentSession().get(Track.class, id);		 
	}

	@Override
	public List<Track> getLastTracks(Integer n) {
		return (List<Track>) criteria()
			.addOrder(Order.desc("idTrack"))
			.setMaxResults(n)
			.list();
	}

	@Override
	public void save(Track track) {
		currentSession().save(track);		
	}
	
	@Override
	public void update(Track track){
		currentSession().update(track);
	}

	@Override
	public Track getTrackByTitle(String title) {
		List<?> list = criteria().add(Restrictions.like("title", title)).list();
		return list.size() > 0 ? (Track) list.get(0) : null;
	}

	@Override
	public Integer getMaxId() {
		return (Integer) criteria()
				.setProjection(Projections.max("idTrack"))
				.list().get(0);
	}

	@Override
	public List<Track> getTracksByRating() {
		return (List<Track>) criteria()
				.addOrder(Order.desc("rating"))
				.list();
	}	
	
	@Override
	public List<Track> getTracksByViews() {
		return (List<Track>) criteria()
				.addOrder(Order.desc("views"))
				.list();
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private Criteria criteria(){
		return sessionFactory.getCurrentSession().createCriteria(Track.class);
	}

}
