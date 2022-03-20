package com.nagarro.Dao;

import java.util.List;


import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.Model.User;

@Transactional
@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveUser(User user) {
		this.hibernateTemplate.save(user);
	}

	public boolean searchUser(String username, String password) {
		TypedQuery query = this.hibernateTemplate.getSessionFactory().getCurrentSession().getNamedQuery("findUser");
		query.setParameter("name", username);
		query.setParameter("pass", password);
		List<User> result = query.getResultList();
	
		if (result.isEmpty()) {
			return false;
		}

		return true;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
