package org.vsp.mup.dao;

import org.vsp.mup.domain.User;

public interface UserDAO {	
	public void addUser(User user);
	public void updateUser(User user);
	public User getUserByUsername(String username);
}
