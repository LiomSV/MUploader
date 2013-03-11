package org.vsp.mup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "role")
public class Role {
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="idRole")
	private Integer idRole;
	
	@Column(name="role")
	private String role;
	
	@Column(name="User_idUser")
	private Integer idUser;
	
	public Integer getIdRole(){
		return idRole;
	}
	
	public String getRole(){
		return role;
	}
	
	public Integer getIdUser(){
		return idUser;
	}
	
	public void setIdRole(Integer idRole){
		this.idRole = idRole;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public void setIdUser(Integer idUser){
		this.idUser = idUser;
	}
}
