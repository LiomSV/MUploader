package org.vsp.mup.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.PlaylistDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Playlist;
import org.vsp.mup.domain.Track;
import org.vsp.mup.domain.User;

@Service
public class PlaylistService {
	@Autowired
	private PlaylistDAO playlistDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private TrackDAO trackDAO;
	
	public void setPlaylistDAO(PlaylistDAO playlistDAO) {
		this.playlistDAO = playlistDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

	private User getUser(String username){
		return userDAO.getUserByUsername(username);
	}
	
	@Transactional
	public List<Playlist> getPlaylistsByUsername(String username) {
		User user = getUser(username);
		Hibernate.initialize(user.getPlaylists());
		return user.getPlaylists();
	}

	@Transactional
	public void createPlaylist(String username, String playlistName) {
		Playlist playlist = new Playlist(playlistName);
		playlist.setUser(getUser(username));
		playlistDAO.save(playlist);
	}

	@Transactional
	public Playlist getPlaylist(String username, Integer idPlaylist) {
		Playlist playlist = playlistDAO.getPlaylistById(idPlaylist);
		if (playlist.getUser().equals(getUser(username))){
			Hibernate.initialize(playlist.getTracks());
			return playlist;
		} else return null;
	}

	@Transactional
	public void addTrackToPlaylist(Integer idTrack, Integer idPlaylist) {
		Track track = trackDAO.getTrackById(idTrack);
		Playlist playlist = playlistDAO.getPlaylistById(idPlaylist);
		playlist.getTracks().add(track);
		playlistDAO.update(playlist);
	}

	@Transactional
	public void deletePlaylist(Integer idPlaylist, String username) {
		Playlist playlist = playlistDAO.getPlaylistById(idPlaylist);
		playlistDAO.delete(playlist);
	}
	
}
