package org.vsp.mup.service;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.vsp.mup.dao.ArtistDAO;
import org.vsp.mup.dao.TagDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;

@Service
public class TrackUploadService {
	private static final String DEFAULT_ARTIST = "artist";
	
	@Autowired
	private TrackDAO trackDAO;
	
	@Autowired
	private TagDAO tagDAO;
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}

	public void setArtistDAO(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public Track newTrack(){
		Track track = new Track();
		trackDAO.saveTrack(track);
		return track;
	}
	
	public void initiateTrack(Track track){
		track.setRating(0);
		track.setViews(0);
		track.setTime(new Date());
		track.setFile("aaaa");  //<---- THIS MUST BE REFACTORED!!!!!!!!!!!!!!!! TEMPLATE 
	}
	
	@Transactional
	public void addNewTrack(Track track, String artistName, String tagLine, String username, MultipartFile uploadForm){
		initiateTrack(track);
		track.setFile(saveToFile(uploadForm));
		track.setTags(parseTagLine(tagLine));
		track.setArtist(addArtist(new Artist(artistName)));
		track.setUser(userDAO.getUserByUsername(username));
		trackDAO.saveTrack(track);		
	}
	
	public Set<Tag> parseTagLine(String tagLine){
		StringTokenizer tagTokens = new StringTokenizer(tagLine, ", ", false);
		Set<Tag> tags = new HashSet<Tag>();
		while (tagTokens.hasMoreTokens()){
			String token = tagTokens.nextToken();
			if (token != ""){
				tags.add(addTag(new Tag(token)));
			}
		}
		return tags;
	}
	
	public Tag addTag(Tag tag){
		Tag existedTag = tagDAO.getTagByTagname(tag.getTagname());
		if (existedTag == null){
			tagDAO.saveTag(tag);
			existedTag = tagDAO.getTagByTagname(tag.getTagname());
		}
		return existedTag;
	}
	
	public Artist addArtist(Artist artist){
		Artist existedArtist = artistDAO.getAritstByName(artist.getName());
		if (existedArtist == null){
			artistDAO.saveArtist(artist);
			existedArtist = artistDAO.getAritstByName(artist.getName());
		}
		return existedArtist;
	}
	
	public String saveToFile(MultipartFile uploadForm){
		Integer newId = trackDAO.getMaxId()+1;
		File file = new File("d:\\Workspace\\Java Spring\\MUploader\\src\\main\\webapp\\resources\\mp3\\"
				+ newId + ".mp3");
		try{
			FileUtils.writeByteArrayToFile(file, uploadForm.getBytes());
		} catch (Throwable e){
			e.printStackTrace();
		}
		return newId.toString();
	}
	
}