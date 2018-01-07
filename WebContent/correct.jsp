<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정 </title>
  	<%@ include file="head.jsp" %>
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
<form action = "web_correct.jsp?idx=<%=idx%>" method = "post" onsubmit="return formCheck();">
<div class="form-group">
	<label for="text">제목 : </label>
	<input type="text" name="title" class="form-control" value="<%=title%>"/>
</div>
<div class="form-group">
	<label for="text">작성자  : </label>
	<input type="text" name="writer" class="form-control" value="<%=writer%>"/>
</div>

<div class="form-group">
	<label for="text">내용   : </label>
	<textarea rows="10" name="content" class="form-control" ><%=content%></textarea>
</div>	
<button type="submit" class="btn btn-default">submit</button>
</form>
</div>
<script>
	function formCheck(){
	    var title = document.forms[0].title.value;     
	    var writer = document.forms[0].writer.value;
	    var content = document.forms[0].content.value; 
	    
	   	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	    if (title == null || title == ""){                                    // null인지 비교한 뒤
	        alert('제목을 입력하세요');                                   // 경고창을 띄우고
	        document.forms[0].title.focus();                           // 해당태그에 포커스를 준뒤
	        return false;                                                     // false를 리턴합니다.
	    }
	 
	    if (writer == null ||  writer  == ""){          
	        alert('작성자를 입력하세요'); 
	        document.forms[0].writer.focus();                      
	        return false;               
	    }else if(writer.match(/^(\w+)@(\w+)[.](\w+)$/ig) == null){
	        alert('이메일 형식으로 입력하세요'); 
	        document.forms[0].writer.focus();                      
	        return false; 
	    }
	
	}
</script>
</body>
</html>