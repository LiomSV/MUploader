package org.vsp.mup.helper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vsp.mup.domain.Track;

@Service
public class StringHelper {
	
	/**
	 * Method deletes spaces at beginning and end of string.   
	 * @param s
	 * @return
	 */
	public static String deleteSpaces(String s){
		int first;
		for(first = 0; (first < s.length()) && (s.charAt(first) == ' '); ++first);
		int last;
		for(last = s.length()-1; (last > -1) && (s.charAt(last) == ' ') && (last > first); --last);		
		return s.substring(first, last+1);
	}
	
	/**
	 * 	Method returns first letter in upper case, if it is contained in pattern,
	 * and returns notLetter otherwise.
	 * Default pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".
	 * Default notLetter = "#".
	 * @param s
	 * @return
	 */
	public static String getFirstLetter(String s){
		if (pattern.contains(s.subSequence(0, 1))){
			return s.toUpperCase().substring(0, 1);
		}
		return notLetter;
	}
	
	private static final String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String notLetter = "#";
	
	/**
	 *  Method groups all pathes of playlist's files to one string.
	 * It's necessary for audio player.
	 * @param tracks
	 * @return
	 */
	public static String groupPlaylistFiles(List<Track> tracks){
		if (tracks.isEmpty()) return "";
		StringBuffer buffer = new StringBuffer();
		for(Track track : tracks){
			buffer.append(PATH_PREFIX);
			buffer.append(track.getFile());
			buffer.append(PATH_POSTFIX+",");
		}
		return buffer.substring(0, buffer.length()-1);
	}
	
	private static final String PATH_PREFIX = "resources/mp3/";
	private static final String PATH_POSTFIX = ".mp3";
	
	/**
	 *  Method groups all titles from playlist to one string.
	 * It's necessary for audio player.
	 * @param tracks
	 * @return
	 */
	public static String groupPlaylistTitles(List<Track> tracks){
		if (tracks.isEmpty()) return "";
		StringBuffer buffer = new StringBuffer();
		for(Track track : tracks){
			buffer.append(track.getTitle()+",");
		}
		return buffer.substring(0, buffer.length()-1);
	}
	
	/**
	 *  Method groups all artist names from playlist to one string.
	 * It's necessary for audio player. 
	 * @param tracks
	 * @return
	 */
	public static String groupPlaylistArtists(List<Track> tracks){
		if (tracks.isEmpty()) return "";
		StringBuffer buffer = new StringBuffer();
		for(Track track : tracks){
			buffer.append(track.getArtist().getName()+",");
		}
		return buffer.substring(0, buffer.length()-1);
	}
}
