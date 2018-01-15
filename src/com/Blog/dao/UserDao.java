package com.Blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Blog.beans.User;

public class UserDao extends CommonDao{

	public static UserDao getInstance() {
		UserDao _instance = new UserDao();
		_instance.SetDB();
		return _instance;
	}
	
	public void setUser(User user) throws SQLException{

		GetDB().insert("setUser", user);
 	}

	public User getUser(String id) throws SQLException{

		User user = null;
		user = (User)GetDB().queryForObject("getUser", id);
		
		return user;
	}
	
	public int isAuthenticate(String id, String passwd) throws SQLException{
		// TODO Auto-generated method stub
		User user = getUser(id);
		int result = -1;
		if(passwd.equals(user.getPasswd()))
			result = 1;
		else
			result = 0;
		
		return result;

	}
	
}
