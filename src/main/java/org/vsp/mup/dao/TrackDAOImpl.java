package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Track;

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

}
