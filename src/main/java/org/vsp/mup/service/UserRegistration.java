package org.vsp.mup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vsp.mup.Main;
import org.vsp.mup.dao.RoleDAO;
import org.vsp.mup.dao.UserDAO;
import org.vsp.mup.domain.Role;
import org.vsp.mup.domain.User;

@Service
public class UserRegistration {	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage message;		
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	private User user;
	
	public UserRegistration(){
		
	}	
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}	
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void setRoleDAO(RoleDAO roleDAO){
		this.roleDAO = roleDAO;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	@Transactional
	public void registrate(){
		addUser();	
		addRole();
		sendMessage(generateLink());
	}
	
	public void sendMessage(String link) {		 
		message.setFrom("MusicUploader");
		message.setTo(user.getMail());
		message.setSubject("Activation on MusicUploader");
		message.setText(Main.ACTIVATION_MESSAGE_1 + user.getUsername() + Main.ACTIVATION_MESSAGE_2 + user.getPassword() + Main.ACTIVATION_MESSAGE_3 + link + Main.ACTIVATION_MESSAGE_4);
		mailSender.send(message);	
	}
	
	@Transactional
	public void addUser() {
	   userDAO.addUser(user);
	}
	
	@Transactional
	public void addRole() {
	    User user = userDAO.getUserByUsername(this.user.getUsername());
	    Role role = new Role();
	    role.setRole(Role.ROLE_USER);
	    role.setIdUser(user.getIdUser());
		roleDAO.addRole(role);
	}
	
	private String generateLink(){
		StringBuffer link = new StringBuffer(Main.DOMAIN_NAME);
		link.append("/mup/activate/");
		link.append(Activation.generateActivationCode(user));
		return new String(link);
	}
}
