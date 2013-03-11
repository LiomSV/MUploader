package org.vsp.mup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.RoleDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Role;
import org.vsp.mup.domain.User;

@Service
public class AdminService {
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	public void setRoleDAO(RoleDAO roleDAO){
		this.roleDAO = roleDAO;
	}
	
	@Transactional
	public List<User> getRoleUserList(){
		List<User> userList = new ArrayList<User>();
		List<Role> idList = roleDAO.getUserIdList();
		for(Role role : idList){
			userList.add(userDAO.getUserById(role.getIdUser()));
		}
		return userList;
	}
}
