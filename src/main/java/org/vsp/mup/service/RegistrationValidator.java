package org.vsp.mup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.User;

@Service
public class RegistrationValidator {
	
	@Autowired
	private UserDAO userDAO;
	private User user;
	private String confirmPassword;
	
	public final static String EMPTY_USERNAME = "emptyUsername";
	public final static String EMPTY_PASSWORD = "emptyPassword";
	public final static String PASSWORD_IS_NOT_CONFIRMED = "confirmPassword";
	public final static String USER_EXIST = "userExist";
	public final static String INVALID_MAIL = "invalidMail";
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword = confirmPassword;
	}
	
	@Transactional
	public List<String> getErrorList(){
		List<String> errorList = new ArrayList<String>();
		if (isUsernameEmpty()){
			errorList.add(EMPTY_USERNAME);
		}
		if (isPasswordEmpty()){
			errorList.add(EMPTY_PASSWORD);
		}
		if (!isPasswordConfirmed()){
			errorList.add(PASSWORD_IS_NOT_CONFIRMED);
		}
		if (isUserExist()){
			errorList.add(USER_EXIST);
		}
		if (!isMailValid()){
			errorList.add(INVALID_MAIL);
		}
		return errorList;
	}
	
	public boolean isUsernameEmpty(){
		return user.getUsername().length() == 0;
	}
	
	public boolean isPasswordEmpty(){
		return user.getPassword().length() == 0;
	}
		
	public boolean isPasswordConfirmed(){
		return user.getPassword().equals(confirmPassword);
	}
	
	@Transactional
	public boolean isUserExist(){
		return userDAO.getUserByUsername(user.getUsername()) != null;
	}
	
	public boolean isMailValid(){
		return (user.getMail().indexOf('@') >= 0) 
			   && (user.getMail().indexOf('@') == user.getMail().lastIndexOf('@')) 
			   && (user.getMail().indexOf('@') < user.getMail().lastIndexOf('.'))
			   && (user.getMail().length() >= 5)
			   ;
			 		
	}
}
