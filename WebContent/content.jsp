<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="head.jsp" %>
<title>Insert title here</title>
</head>
<body>

<div class="container">
<div class="col-md-12">
	<div class="page-header">
		<h3>${article.title }</h3>	
	</div>
</div>

<div class="panel panel-default">
<div class="panel-heading">
	<h4 class="panel-title">
		글번호: ${article.idx} &nbsp; 글쓴이: ${article.writer} &nbsp; 등록일: ${article.regdate} &nbsp; 조회수: ${article.count }
	</h4>
</div>
<div class="panel-body">
	<div class="content post" style="line-height:30px;" >
	${article.content }
	</div>
</div>
</div>

<a href = "delete.do?idx=${article.idx}" class="btn btn-default">삭제  </a>
<a href = "correct.do?idx=${article.idx}" class="btn btn-default">수정 </a>
<a href = "list.do" class="btn btn-default">목록 </a>
</div>
</body>
</html>