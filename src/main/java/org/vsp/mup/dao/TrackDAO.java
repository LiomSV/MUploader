package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Track;

public interface TrackDAO {
	public void saveTrack(Track track);
	public Track getTrackById(Integer id);
	public List<Track> getLastTracks(Integer n);
	public Track getTrackByTitle(String title);
	public Integer getMaxId();
}
