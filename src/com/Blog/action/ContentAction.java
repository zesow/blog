package com.Blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;
import java.sql.*;
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		Connection conn = null;
		ResultSet rs = null;
		try{
			String url = "jdbc:mysql://localhost:3306/Blog";        // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "root";                                                    // 사용자 계정
			String pw = "200101";                                               // 사용자 계정의 패스워드
			Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Blog WHERE idx=" + idx ;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				request.setAttribute("idx", rs.getString("idx"));
				request.setAttribute("writer", rs.getString("writer"));
				request.setAttribute("regdate", rs.getString("regdate"));
				request.setAttribute("count", rs.getString("count"));
				request.setAttribute("title", rs.getString("title"));
				request.setAttribute("content", rs.getString("content"));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "content.jsp";
	}

}
