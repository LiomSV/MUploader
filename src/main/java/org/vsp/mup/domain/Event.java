package org.vsp.mup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event")
public class Event {
	public static final Integer CODE_LIKE = 1;
	public static final Integer CODE_VIEW = 2;
	
	public Event(){		
	}
	
	public Event(Integer code, Track track, User user) {
		this.code = code;
		this.track = track;
		this.user = user;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private Integer id;
	
	@Column(name="code")
	private Integer code;
	
	public Integer getId() {
		return id;
	}

	public Integer getCode() {
		return code;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	private Track track;
	
	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	public User getUser(){
	    return user;
	}

	public void setUser(User user){
		this.user = user;
	}
}
