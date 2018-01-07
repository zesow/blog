<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import = "java.util.regex.Pattern" %>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String regdate = request.getParameter("regdate");
	String content = request.getParameter("content");
	System.out.println(title);
	if(title == "" ||title == null) out.println("title이 null입니다.");
	 
	if(writer == "" ||writer == null)
	    out.println("writer가 null입니다.");   
	else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
	    out.println("이메일 형식이 아닙니다.");
	 
	if(content == "" ||content == null) out.println("content가 null입니다.");
	
	Connection conn = null;
	
	try{
			
		String url = "jdbc:mysql://localhost:3306/Blog";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "root";                                                    // 사용자 계정
		String pw = "200101";                                               // 사용자 계정의 패스워드
		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

		conn=DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.

		out.println("제대로 연결되었습니다.");                            // 커넥션이 제대로 연결되면 수행된다.
		
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO BLOG" + " (TITLE,WRITER,REGDATE,COUNT,CONTENT)" +
					" VALUES ('" + title + "', '" + writer + "', " + "NOW()" + ", '" + 1 + "', '" + content + "')";
		out.write(sql);
		
		stmt.executeUpdate(sql);
		
		conn.close();
		}catch(Exception e){                                                    // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
		}finally{
			out.print("<script>location.href='index.jsp';</script>");
		}
%>
</body>
</html>