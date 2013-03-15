package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.User;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);	
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User getUserByUsername(String username) {
		List<?> userList = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.like("username", username))
				.list();
		return userList.size() > 0 ? (User)userList.get(0) : null;
	
	}

	@Override
	public User getUserById(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}	
	
}
