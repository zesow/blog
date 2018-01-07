<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import= "java.util.regex.Pattern" %>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문상 블로그 </title>
	<%@ include file="head.jsp" %>
</head>
<body>
<%
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
		
%>


<div class="container">

	<h1>테이블 </h1>
	<table class = "table table-striped table-hover">
		<thead>
		<tr>
			<th>번호 </th>
			<th>제목 </th>
			<th>작성자 </th>
			<th>날짜 </th>
			<th>조회수 </th>
		</tr>
		</thead>
		<tbody>
		<%
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getString(1) + "</td>");
				out.print("<td> <a href=content.jsp?idx="+rs.getString("idx") + ">" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("<td>" + rs.getString(4) + "</td>");
				out.print("<td>" + rs.getString(5) + "</td>");
				out.print("</tr>");
			}
			conn.close();
			}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
			}
		%>
		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
	<a href = "write.jsp" class="btn btn-default">글쓰기 </a>
</div>
</body>
</html>