package org.vsp.mup.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vsp.mup.domain.Tag;

@Repository
public class TagDAOImpl implements TagDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Tag> getPopularTags(Integer n) {
		return (List<Tag>) sessionFactory.getCurrentSession()
				.createCriteria(Tag.class)
				.addOrder(Order.desc("popularity"))
				.setMaxResults(n)
				.list();
	}

	@Override
	public List<Tag> getAllTags() {
		return (List<Tag>) sessionFactory.getCurrentSession()
				.createCriteria(Tag.class)
				.list();
	}

	@Override
	public void upgateTag(Tag tag) {
		sessionFactory.getCurrentSession().update(tag);
	}

}
