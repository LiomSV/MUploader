package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Artist;

public interface ArtistDAO {
	public void saveArtist(Artist artist);
	public Artist getArtistById(Integer id);
	public Artist getAritstByName(String name);
	public List<Artist> getAllArtistsSortedByName();
}
