package com.Blog.dao;

import java.sql.*;

public class CommonDao {
	private final String driverName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/Blog";        // 사용하려는 데이터베이스명을 포함한 URL 기술
	private final String id = "root";                                                    // 사용자 계정
	private final String pw = "200101";
	
	private Connection con = null;
	private Statement stmt = null;
	
	public Statement openConnection() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,id,pw);
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	public void closeConnection() {
		try {
			if(!con.isClosed())
				con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
