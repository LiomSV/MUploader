package org.vsp.mup.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.ArtistDAO;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.domain.Track;
import org.vsp.mup.helper.ArtistUnit;
import org.vsp.mup.helper.StringHelper;

@Service
public class ArtistPageService {
	public static final int TRACKS_ON_PAGE = 9;
	
	@Autowired
	private ArtistDAO artistDAO;

	public void setArtistDAO(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}
	
	@Transactional
	public Artist getArtistWithTracks(Integer idArtist){
		Artist artist = artistDAO.getArtistById(idArtist);
		Hibernate.initialize(artist.getTracks());
		return artist;		
	}
	
	public Integer getPagesQuantity(Artist artist){
		return (artist.getTracks().size()+TRACKS_ON_PAGE-1)/TRACKS_ON_PAGE;
	}
	
	public List<Track> getTracksForPage(Artist artist, Integer page){
		List<Track> trackList = new ArrayList<Track>();
		for(int i = 0; (i < artist.getTracks().size()) && (i < TRACKS_ON_PAGE); ++i){
			trackList.add(artist.getTracks().get((page-1)*TRACKS_ON_PAGE+i));
		}
		return trackList;
	}
	
	@Transactional
	public List<ArtistUnit> getSplitedArtistsList(){
		List<Artist> sortedArtistList = artistDAO.getAllArtistsSortedByName();
		List<ArtistUnit> splited = new ArrayList<ArtistUnit>();
		for(Artist artist : sortedArtistList){
			if ( ( splited.isEmpty() ) || ( !splited.get( splited.size()-1 ).getLetter().equals( StringHelper.getFirstLetter( artist.getName() ) ) ) ){
				splited.add(new ArtistUnit(artist));
			} else {
				splited.get(splited.size()-1).add(artist);
			}
		}
		return splited;
	}
	
}
