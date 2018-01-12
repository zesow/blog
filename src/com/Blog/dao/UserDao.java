package com.Blog.dao;

import java.sql.ResultSet;
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


	public int isAuthenticate(String id, String passwd) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "SELECT id,passwd FROM user WHERE id = '" + id + "'";
		System.out.println(id + "," + passwd);
		ResultSet rs = openConnection().executeQuery(sql);
		
		String r_passwd = null;
		int result = -1;
		if(rs.next()) {
			r_passwd = rs.getString("passwd");
			
			if(passwd.equals(r_passwd)) 
				result = 1;
			else
				result = 0;
		}
		else {
			result = -1;
		}
			
		return result;
	}
}
