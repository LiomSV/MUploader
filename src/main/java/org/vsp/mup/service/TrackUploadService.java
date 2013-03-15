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
import org.vsp.mup.dao.ArtistDAO;
import org.vsp.mup.dao.TagDAO;
import org.vsp.mup.dao.TrackDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Artist;
import org.vsp.mup.domain.Tag;
import org.vsp.mup.domain.Track;

@Service
public class TrackUploadService {
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

	public void initiateTrack(Track track){
		track.setRating(0);
		track.setViews(0);
		track.setTime(new Date());
	}
	
	@Transactional
	public void addNewTrack(Track track, String artistName, String tagLine, String username){
		initiateTrack(track);
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
	
	@Transactional
	public String saveToFile(UploadedFile uploadedFile){
		Integer newId = trackDAO.getMaxId()+1;
		File file = new File("c:\\Program Files (x86)\\springsource\\vfabric-tc-server-developer-2.7.2.RELEASE\\base-instance\\wtpwebapps\\MUploader\\resources\\mp3\\"
				+ newId + ".mp3");
		File file2 = new File("d:\\Workspace\\Java Spring\\MUploader\\src\\main\\webapp\\resources\\mp3\\"
				+ newId + ".mp3");
		try{
			FileUtils.writeByteArrayToFile(file, uploadedFile.getFile());
			FileUtils.writeByteArrayToFile(file2, uploadedFile.getFile());
		} catch (Throwable e){
			e.printStackTrace();
		}
		return newId.toString();
	}
	
	public String deleteSpaces(String s){
		int first;
		for(first = 0; (first < s.length()) && (s.charAt(first) == ' '); ++first);
		int last;
		for(last = s.length()-1; (last > -1) && (s.charAt(last) == ' ') && (last > first); --last);		
		return s.substring(first, last+1);
	}
	
}