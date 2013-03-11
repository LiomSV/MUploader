package org.vsp.mup.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role role) {		
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void deleteRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}
	
	
}
