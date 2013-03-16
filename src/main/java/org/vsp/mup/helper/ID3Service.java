package org.vsp.mup.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.vsp.mup.domain.Track;

import entagged.audioformats.AudioFile;
import entagged.audioformats.AudioFileIO;
import entagged.audioformats.Tag;
import entagged.audioformats.exceptions.CannotReadException;
import entagged.audioformats.exceptions.CannotWriteException;

public class ID3Service {
	public static final int TITLE = 0;
	public static final int ARTIST = 1;
	public static final int GENRE = 2;
	public static final int COMMENT = 3;
	
	/**
	 * 	Method gets and returns ID3 tags list.
	 * @param file
	 * @return
	 */
	public static List<String> getID3(File file){
		List<String> id3List = new ArrayList<String>();
		id3List.add(getTitle(file));
		id3List.add(getArtist(file));
		id3List.add(getGenre(file));
		id3List.add(getComment(file));
		return id3List;
	}
	
	/**
	 *  Method sets track title, artist name, track genre and track description to list.
	 * @param id3List
	 * @param track
	 * @param artistName
	 */
	public static void initID3List(List<String> id3List, Track track, String artistName){
		id3List.set(TITLE, track.getTitle());
		id3List.set(ARTIST, artistName);
		id3List.set(GENRE, track.getGenre());
		id3List.set(COMMENT, track.getDescription());
	}
	
	/**
	 * 	Method updates ID3 tags in track file.
	 * @param track
	 */
	public static void updateID3(Track track){
		File file = new File("c:\\Program Files (x86)\\springsource\\vfabric-tc-server-developer-2.7.2.RELEASE\\base-instance\\wtpwebapps\\MUploader\\resources\\mp3\\"
				+ track.getFile() + ".mp3");
		setTitle(file, track.getTitle());
		setArtist(file, track.getArtist().getName());
		setGenre(file, track.getGenre());
		setComment(file, track.getDescription());
		
		File file2 = new File("d:\\Workspace\\Java Spring\\MUploader\\src\\main\\webapp\\resources\\mp3\\"
				+ track.getFile() + ".mp3");
		setTitle(file2, track.getTitle());
		setArtist(file2, track.getArtist().getName());
		setGenre(file2, track.getGenre());
		setComment(file2, track.getDescription());
	}
	
	public static String getTitle(File file){
		Tag tag = getTag(file);
		return tag.getFirstTitle();
	}
	
	public static String getArtist(File file){
		Tag tag = getTag(file);
		return tag.getFirstArtist();
	}
	
	public static String getGenre(File file){
		Tag tag = getTag(file);
		return tag.getFirstGenre();
	}
	
	public static String getComment(File file){
		Tag tag = getTag(file);
		return tag.getFirstComment();
	}
	
	public static void setTitle(File file, String title){
		AudioFile audioFile = getAudioFile(file);
		audioFile.getTag().addTitle(title);
		write(audioFile);		
	}
	
	public static void setArtist(File file, String artist){
		AudioFile audioFile = getAudioFile(file);
		audioFile.getTag().addArtist(artist);
		write(audioFile);
	}
	
	public static void setGenre(File file, String genre){
		AudioFile audioFile = getAudioFile(file);
		audioFile.getTag().addGenre(genre);
		write(audioFile);
	}

	public static void setComment(File file, String comment){
		AudioFile audioFile = getAudioFile(file);
		audioFile.getTag().addComment(comment);
		write(audioFile);
	}
	
	private static Tag getTag(File file){
		AudioFileIO audioFileIO = new AudioFileIO();
		AudioFile audioFile = null;
		try{	
			audioFile = audioFileIO.readFile(file);
		} catch (CannotReadException e){
			e.printStackTrace();
		}
		return audioFile.getTag();
	}
	
	private static AudioFile getAudioFile(File file){
		AudioFileIO audioFileIO = new AudioFileIO();
		AudioFile audioFile = null;
		try{	
			audioFile = audioFileIO.readFile(file);
		} catch (CannotReadException e){
			e.printStackTrace();
		}
		return audioFile;
	}
	
	private static void write(AudioFile audioFile){
		AudioFileIO audioFileIO = new AudioFileIO();
		try {
			audioFileIO.writeFile(audioFile);
		} catch (CannotWriteException e) {
			e.printStackTrace();
		}
	}
}
