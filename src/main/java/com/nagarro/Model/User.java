package com.nagarro.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findUser",  
	        query = "from User u where u.username =:name and u.password=:pass"
	        )  
	    }  
	) 
@Entity
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String password;
	
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}



