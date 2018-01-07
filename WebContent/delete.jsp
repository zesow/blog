<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String temp = request.getParameter("idx");
	System.out.println(temp);
	int idx = Integer.parseInt(temp); 
	Connection conn = null;
	ResultSet rs = null;
	try{
		String url = "jdbc:mysql://localhost:3306/Blog";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "root";                                                    // 사용자 계정
		String pw = "200101";                                               // 사용자 계정의 패스워드
		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

		conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
		
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM Blog WHERE idx=" + idx ;
		stmt.executeUpdate(sql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<script>
	alert("삭제되었습니다");
	location.href="redirect.jsp";
</script>
</body>
</html>