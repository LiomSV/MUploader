package org.vsp.mup.dao;

import java.util.List;

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
		return (Track)sessionFactory.getCurrentSession().get(Track.class, id);		 
	}

	@Override
	public List<Track> getLastTracks(Integer n) {
		return (List<Track>) sessionFactory.getCurrentSession()
			.createCriteria(Track.class)
			.addOrder(Order.desc("idTrack"))
			.setMaxResults(n)
			.list();
	}

	@Override
	public void saveTrack(Track track) {
		sessionFactory.getCurrentSession().save(track);		
	}

	@Override
	public Track getTrackByTitle(String title) {
		List<?> list = sessionFactory.getCurrentSession()
			.createCriteria(Track.class)
			.add(Restrictions.like("title", title))
			.list();
		return list.size() > 0 ? (Track) list.get(0) : null;
	}

	@Override
	public Integer getMaxId() {
		return (Integer) sessionFactory.getCurrentSession()
				.createCriteria(Track.class)
				.setProjection(Projections.max("idTrack"))
				.list().get(0);
	}	
}
