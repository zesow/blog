<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import= "java.util.regex.Pattern" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문상 블로그 </title>
	<%@ include file="../partial/head.jsp" %>
</head>
<body>
<%@ include file="../partial/navbar.jsp" %>
<div class="container">

	<h1>게시판 </h1>
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
		
			<c:forEach items="${articleList}" var="article">
				<tr>
					<td>${article.idx}</td>
					<td><a href='content.do?idx=${article.idx}'>${article.title}</a></td>
					<td>${article.writer}</td>
					<td>${article.regdate}</td>
					<td>${article.count}</td>
				</tr>
			</c:forEach>

		
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
	<a href = "write.do" class="btn btn-default">글쓰기 </a>
</div>
</body>
</html>