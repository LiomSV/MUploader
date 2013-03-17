package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Playlist;
import org.vsp.mup.domain.User;

@Repository
public class PlaylistDAOImpl implements PlaylistDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Playlist playlist) {
		sessionFactory.getCurrentSession().save(playlist);
	}

	@Override
	public void update(Playlist playlist) {
		sessionFactory.getCurrentSession().update(playlist);
	}

	@Override
	public List<Playlist> getPlaylistsByUser(User user) {
		return (List<Playlist>) sessionFactory.getCurrentSession()
				.createCriteria(Playlist.class)
				.add(Restrictions.like("user", user))
				.list();		
	}

	@Override
	public Playlist getPlaylistById(Integer idPlaylist) {
		return (Playlist) sessionFactory.getCurrentSession().get(Playlist.class, idPlaylist); 
	}

	@Override
	public void delete(Playlist playlist) {
		sessionFactory.getCurrentSession().delete(playlist);
	}

}
