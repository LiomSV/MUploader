package org.vsp.mup.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Playlist")
public class Playlist {	
	public Playlist(){}
	
	public Playlist(String name){
		this.name = name;
	}	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idPlaylist")
	private Integer idPlaylist;
	
	@Column(name = "name")
	private String name;

	public Integer getIdPlaylist() {
		return idPlaylist;
	}

	public String getName() {
		return name;
	}

	public void setIdPlaylist(Integer idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	public User getUser(){
	    return user;
	}

	public void setUser(User user){
		this.user = user;
	}
	
	@Fetch (FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Playlist_has_Track", 
		joinColumns = { @JoinColumn(name = "Playlist_idPlaylist") }, 
		inverseJoinColumns = { @JoinColumn(name = "Track_idTrack") } )
	private List<Track> tracks = new ArrayList<Track>();

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
