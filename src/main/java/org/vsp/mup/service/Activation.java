package org.vsp.mup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.User;

@Service
public class Activation {
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	/**
	 * Returns activation code for proper user. 
	 * @param user
	 * @return activation code for proper user
	 */
	public static String generateActivationCode(User user){
		StringBuffer code = new StringBuffer();
		for(char c : user.getUsername().toLowerCase().toCharArray() ){
			code.append((int)c - 87);
		}
		return new String(code);
	}
	
	/**
	 * Decodes activation code and returns username of proper user. 
	 * @param code
	 * @return username 
	 */
	public static String decodeActivationCode(String code){
		StringBuffer username = new StringBuffer();
		for(int i=0; i < code.length(); i+=2){			
			username.append((char)(Integer.valueOf(code.substring(i, i+2)).intValue()+87));
		}
		return new String(username);
	}
	
	@Transactional
	public boolean activateUserByCode(String code){
		return activateUserByUsername(decodeActivationCode(code));
	}
	
	@Transactional
	public boolean activateUserByUsername(String username){
		return activateUser(userDAO.getUserByUsername(username));	
	}
	
	@Transactional
	public boolean activateUserById(Integer id){
		return activateUser(userDAO.getUserById(id));		
	}
	
	@Transactional
	public boolean deactivateUserById(Integer id){
		return deactivateUser(userDAO.getUserById(id));		
	}
	
	@Transactional
	private boolean activateUser(User user){
		if (user == null){
			return false;
		}
		user.setEnabled(true);
		userDAO.updateUser(user);
		return true;
	}
	
	@Transactional
	private boolean deactivateUser(User user){
		if (user == null){
			return false;
		}
		user.setEnabled(false);
		userDAO.updateUser(user);
		return true;
	}
	
}
