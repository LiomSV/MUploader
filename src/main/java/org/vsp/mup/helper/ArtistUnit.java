package org.vsp.mup.helper;

import java.util.ArrayList;

import org.vsp.mup.domain.Artist;

/**
 * Class, representing list of artists with identical first letter.
 * Class extends ArrayList<Artist>, so it has 'add', 'get' and 'set' methods.
 * @author Lion
 *
 */
public class ArtistUnit extends ArrayList<Artist>{
	private String letter;
	
	public String getLetter() {
		return letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter.toUpperCase();
	}
	
	public ArtistUnit(){
		super();
	}
	
	public ArtistUnit(Artist artist){
		super();
		add(artist);
		letter = StringHelper.getFirstLetter(artist.getName());
	}
}
