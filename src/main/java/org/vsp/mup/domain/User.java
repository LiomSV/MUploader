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
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idUser")
	private Integer idUser;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "mail")
	private String mail;
	
	public Integer getIdUser(){
		return idUser;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public boolean getEnabled(){
		return enabled;
	}
	
	public String getMail(){
		return mail;
	}
	
	public void setIdUser(Integer idUser){
		this.idUser = idUser;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	@OneToMany(mappedBy = "user")
	private List<Track> tracks;
	
	public List<Track> getTracks(){
		return tracks;
	}
	
	public void setTracks(List<Track> tracks){
		this.tracks = tracks;
	}
	
}
