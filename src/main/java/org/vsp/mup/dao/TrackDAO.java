package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Track;

public interface TrackDAO {
	public Track getTrackById(Integer id);
	public List<Track> getLastTracks(Integer n);
}
