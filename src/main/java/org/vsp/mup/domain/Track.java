package org.vsp.mup.domain;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "track")
public class Track {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idTrack")
	private Integer idTrack;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="file")
	private String file;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="views")
	private Integer views;
	
	@Column(name="time")
	private Date time;
	
	@Column(name="User_idUser")
	private Integer idUser;
	
	@Column(name="Artist_idArtist")
	private Integer idArtist;
	
	public Integer getIdTrack() {
		return idTrack;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getGenre() {
		return genre;
	}

	public String getFile() {
		return file;
	}

	public Integer getRating() {
		return rating;
	}

	public Integer getViews() {
		return views;
	}

	public Date getTime() {
		return time;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public Integer getIdArtist() {
		return idArtist;
	}

	public void setIdTrack(Integer idTrack) {
		this.idTrack = idTrack;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}
	
	@ManyToOne
	private User user;
	
	public User getUser(){
	    return user;
	}

	public void setUser(User user){
		this.user = user;
	}
	
	@ManyToOne
	private Artist artist;

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	@Fetch (FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "Track_has_Tag", 
		joinColumns = { @JoinColumn(name = "Track_idTrack") }, 
		inverseJoinColumns = { @JoinColumn(name = "Tag_idTag") } )
	private Set<Tag> tags = new TreeSet<Tag>();

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
}
