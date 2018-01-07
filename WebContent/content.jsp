<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%
	String temp = request.getParameter("idx");
	String title =null,writer=null,regdate=null,count=null,content=null;
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
		String sql = "SELECT * FROM Blog WHERE idx=" + idx ;
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			title = rs.getString("title");
			writer = rs.getString("writer");
			regdate = rs.getString("regdate");
			count = rs.getString("count");
			content = rs.getString("content");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<div class="container">
<div class="col-md-12">
	<div class="page-header">
		<h3><%=title %></h3>	
	</div>
</div>

<div class="panel panel-default">
<div class="panel-heading">
	<h4 class="panel-title">
		글번호: <%=idx%> &nbsp; 글쓴이: <%=writer %> &nbsp; 등록일: <%=regdate %> &nbsp; 조회수: <%=count %>
	</h4>
</div>
<div class="panel-body">
	<div class="content post" style="line-height:30px;" >
	<%=content %>
	</div>
</div>
</div>

<a href = "delete.jsp?idx=<%=idx %>" class="btn btn-default">삭제  </a>
<a href = "correct.jsp?idx=<%=idx %>" class="btn btn-default">수정 </a>
<a href = "index.jsp" class="btn btn-default">목록 </a>
</div>
</body>
</html>