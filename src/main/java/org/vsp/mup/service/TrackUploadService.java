package org.vsp.mup.service;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import org.vsp.mup.helper.ID3Service;
import org.vsp.mup.helper.StringHelper;
import org.vsp.mup.helper.UploadedFile;

@Service
public class TrackUploadService {
	public static final int TITLE = 0;
	public static final int ARTIST = 1;
	public static final int GENRE = 2;
	public static final int COMMENT = 3;
	
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
		correctTrack(track, artistName);
		track.setTags(parseTagLine(tagLine));
		track.setArtist(addArtist(new Artist(artistName)));		
		trackDAO.saveTrack(track);		
		ID3Service.updateID3(track);
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
		
	/**
	 * 	Method returns tag from database, if tag with identical tagname already exists,
	 * or just add new tag to database. 
	 * @param tag
	 * @return
	 */
	public Tag addTag(Tag tag){
		Tag existedTag = tagDAO.getTagByTagname(tag.getTagname());
		if (existedTag == null){
			tagDAO.saveTag(tag);
			existedTag = tagDAO.getTagByTagname(tag.getTagname());
		}
		return existedTag;
	}
	
	/**
	 * 	Method returns artist from database, if artist with identical name already exists,
	 * or just add new artist to database.
	 * @param artist
	 * @return
	 */
	public Artist addArtist(Artist artist){
		Artist existedArtist = artistDAO.getAritstByName(artist.getName());
		if (existedArtist == null){
			artistDAO.saveArtist(artist);
			existedArtist = artistDAO.getAritstByName(artist.getName());
		}
		return existedArtist;
	}
	
	/**
	 * 	Method fills file in track by generated from idTrack and username value,
	 * save uploadedFile to this file and returns ID3 from it.   
	 * @param uploadedFile
	 * @param track
	 * @param username
	 * @return
	 */
	@Transactional
	public List<String> saveToFileAndGetID3(UploadedFile uploadedFile, Track track, String username){
		Integer newId = trackDAO.getMaxId()+1;
		track.setUser(userDAO.getUserByUsername(username));
		track.setFile(newId + "_" + track.getUser().getIdUser());
		File file = new File("c:\\Program Files (x86)\\springsource\\vfabric-tc-server-developer-2.7.2.RELEASE\\base-instance\\wtpwebapps\\MUploader\\resources\\mp3\\"
				+ track.getFile() + ".mp3");
		File file2 = new File("d:\\Workspace\\Java Spring\\MUploader\\src\\main\\webapp\\resources\\mp3\\"
				+ track.getFile() + ".mp3");
		try{
			FileUtils.writeByteArrayToFile(file, uploadedFile.getFile());
			FileUtils.writeByteArrayToFile(file2, uploadedFile.getFile());
		} catch (Throwable e){
			e.printStackTrace();
		}
		return ID3Service.getID3(file);
	}	
	
	/**
	 * 	Method makes corrections for track title, track genre and artist name before use it.
	 * (Deletes unnecessary spaces at track title, track genre and artist name in this implementation)
	 */
	private void correctTrack(Track track, String artistName){
		track.setTitle(StringHelper.deleteSpaces(track.getTitle()));
		track.setGenre(StringHelper.deleteSpaces(track.getGenre()));
		artistName = StringHelper.deleteSpaces(artistName);
	}
}