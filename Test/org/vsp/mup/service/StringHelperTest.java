package org.vsp.mup.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.domain.Track;
import org.vsp.mup.helper.StringHelper;

public class StringHelperTest {

	public TrackUploadService trackUploadService = new TrackUploadService();
	
	@Test
	public void deleteSpaces1() {
		String s = "   AAA BBB  CCC    ";		
		assertEquals("AAA BBB  CCC", StringHelper.deleteSpaces(s));
	}
	
	@Test
	public void deleteSpaces2() {
		String s = "AAA BBB  CCC";		
		assertEquals("AAA BBB  CCC", StringHelper.deleteSpaces(s));
	}

	@Test
	public void deleteSpaces3() {
		String s = "       ";		
		assertEquals("", StringHelper.deleteSpaces(s));
	}
	
	@Test
	public void groupPathes() {
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(newTrackWithFile("1_1"));
		tracks.add(newTrackWithFile("1_2"));
		tracks.add(newTrackWithFile("3_1"));
		assertEquals("resources/mp3/1_1.mp3,resources/mp3/1_2.mp3,resources/mp3/3_1.mp3", StringHelper.groupPlaylistFiles(tracks));
	}
	
	private Track newTrackWithFile(String file){
		Track track = new Track();
		track.setFile(file);
		return track;
	}
	
	@Test
	public void groupPathesEmpty() {
		List<Track> tracks = new ArrayList<Track>();
		assertEquals("", StringHelper.groupPlaylistFiles(tracks));
	}

	@Test
	public void groupTitles() {
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(newTrackWithTitle("AAA"));
		tracks.add(newTrackWithTitle("BBB"));
		tracks.add(newTrackWithTitle("CCC"));
		assertEquals("AAA,BBB,CCC", StringHelper.groupPlaylistTitles(tracks));
	}
	
	private Track newTrackWithTitle(String title){
		Track track = new Track();
		track.setTitle(title);
		return track;
	}
	
	@Test
	public void groupTitlesEmpty() {
		List<Track> tracks = new ArrayList<Track>();
		assertEquals("", StringHelper.groupPlaylistTitles(tracks));
	}
	
	@Test
	public void groupArtists() {
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(newTrackWithArtist("AAA"));
		tracks.add(newTrackWithArtist("BBB"));
		tracks.add(newTrackWithArtist("CCC"));
		assertEquals("AAA,BBB,CCC", StringHelper.groupPlaylistArtists(tracks));
	}
	
	private Track newTrackWithArtist(String name){
		Artist artist = new Artist(name);
		Track track = new Track();
		track.setArtist(artist);
		return track;
	}
	
	@Test
	public void groupArtistsEmpty() {
		List<Track> tracks = new ArrayList<Track>();
		assertEquals("", StringHelper.groupPlaylistArtists(tracks));
	}
}
