package com.nagarro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Dao.UserDao;
import com.nagarro.Model.User;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void createUser(User user) {
		 this.userDao.saveUser(user);
		
	}
	

	public boolean validateUser(String username,String password) {
		return this.userDao.searchUser(username,password);
	}

}
