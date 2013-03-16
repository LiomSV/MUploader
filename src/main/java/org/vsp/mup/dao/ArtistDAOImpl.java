package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.domain.Track;

@Repository
public class ArtistDAOImpl implements ArtistDAO {
	private static final String DEFAULT_ARTIST = "default_artist";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveArtist(Artist artist) {
		sessionFactory.getCurrentSession().save(artist);
	}

	@Override
	public Artist getArtistById(Integer id) {
		return (Artist) sessionFactory.getCurrentSession().get(Artist.class, id);
	}

	@Override
	public Artist getAritstByName(String name) {
		List<?> list = sessionFactory.getCurrentSession()
				.createCriteria(Artist.class)
				.add(Restrictions.like("name", name))
				.list();
		return list.size() > 0 ? (Artist) list.get(0) : null;
	}

	@Override
	public List<Artist> getAllArtistsSortedByName() {
		return (List<Artist>) sessionFactory.getCurrentSession()
				.createCriteria(Artist.class)
				.add(Restrictions.not(Restrictions.like("name", DEFAULT_ARTIST)))
				.addOrder(Order.asc("name"))
				.list();		
	}

}
