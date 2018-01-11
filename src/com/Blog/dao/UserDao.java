package com.Blog.dao;

import java.sql.SQLException;

import com.Blog.beans.User;

public class UserDao extends CommonDao{

	public static UserDao getInstance() {
		UserDao _instance = new UserDao();
		
		return _instance;
	}
	
	public void setUser(User user) throws SQLException{
		String sql = "INSERT INTO user" + "(ID,PASSWD,NAME,MAIL,REGDATE)" +
	"VALUES ('" + user.getId() +"', '" + user.getPasswd() + "', '" + user.getName() + "', '" +
				user.getMail() + "', " + "NOW())";
		
		openConnection().executeUpdate(sql);
		closeConnection();
 	}
}
