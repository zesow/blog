package com.Blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;

import java.sql.*;
import com.Blog.beans.Blog;
import java.util.ArrayList;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		try{
			String url = "jdbc:mysql://localhost:3306/Blog";        // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "root";                                                    // 사용자 계정
			String pw = "200101";                                               // 사용자 계정의 패스워드
			Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Blog ORDER BY idx DESC";
			rs = stmt.executeQuery(sql);
			
			ArrayList<Blog> articleList = new ArrayList<Blog>();
			
			while(rs.next()){
				Blog article = new Blog();
				article.setIdx(rs.getInt("idx"));
				article.setTitle(rs.getString("title"));
				article.setWriter(rs.getString("writer"));
				article.setRegdate(rs.getString("regdate"));
				article.setCount(rs.getInt("count"));
				articleList.add(article);
			}
			request.setAttribute("articleList",articleList);
			conn.close();
			}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
			}
		return "list.jsp";
	}
	
}
