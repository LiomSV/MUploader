package org.vsp.mup.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tag")
public class Tag {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idTag")
	private Integer idTag;
	
	@Column(name="tagname")
	private String tagname;

	@Column(name="popularity")
	private Integer popularity;	

	public Integer getIdTag() {
		return idTag;
	}

	public String getTagname() {
		return tagname;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
		
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private List<Track> tracks = new ArrayList<Track>();

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public Tag(){
		this.popularity = 0;
	}
	
	public Tag(String tagname){
		this();
		this.tagname = tagname;
	}
}
