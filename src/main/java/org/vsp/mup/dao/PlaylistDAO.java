package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Playlist;
import org.vsp.mup.domain.User;

public interface PlaylistDAO {
	public void save(Playlist playlist);
	
	public void update(Playlist playlist);
	
	public List<Playlist> getPlaylistsByUser(User user);

	public Playlist getPlaylistById(Integer idPlaylist);

	public void delete(Playlist playlist);
}
