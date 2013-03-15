package org.vsp.mup.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idArtist")
	private Integer idArtist;
	
	@Column(name="name")
	private String name;

	public Integer getIdArtist() {
		return idArtist;
	}

	public String getName() {
		return name;
	}

	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "artist")
	private List<Track> tracks;

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public Artist(){
		
	}
	
	public Artist(String name){
		this.name = name;
	}
}
