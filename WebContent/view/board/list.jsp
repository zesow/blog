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
	<c:if test="${boardno == 1}">
	<h1>프로젝트 </h1>
	</c:if>
	<c:if test="${boardno == 2}">
	<h1>알고리즘 </h1>
	</c:if>
	<c:if test="${boardno == 3}">
	<h1>경제상식 </h1>
	</c:if>
	<c:if test="${boardno == 4}">
	<h1>민법 </h1>
	</c:if>
	<c:if test="${boardno == 5}">
	<h1>사진 </h1>
	</c:if>
	<c:if test="${boardno == 6}">
	<h1>맛집 </h1>
	</c:if>
	
	<table class = "table table-striped table-hover">
		<thead>
		<tr>
			<th>제목 </th>
			<th>작성자 </th>
			<th>날짜 </th>
			<th>조회수 </th>
		</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${articleList}" var="article">
				<tr>
					<td><a href='content.do?idx=${article.idx}'>${article.title}</a></td>
					<td>${article.writer}</td>
					<td>${article.regdate}</td>
					<td>${article.count}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
	<!-- 페이지 처리  -->
	<!-- 글이 있을 경우 작동. -->
	<!-- 현재 페이지 is grater than 5 일 경우 '이전 ' 버튼 생성  -->
	<!-- 이번 페이지 그룹의 시작 페이지와 끝 페이지 만큼 버튼 생성. -->
	<!-- 현재 페이지가 선택한 페이지일 경우 파란색 버튼 생성. -->
	<!-- 아닐 경우 그냥 버튼 생성. -->
	<!-- 다음 페이지 그룹이 있을 경우 '다음' 버튼 생성. -->
	<c:choose>
		<c:when test="${paging.numOfRecords ne Null and paging.numOfRecords ne '' and paging.numOfRecords ne 0 }">
			<div class="text-center marg-top">
				<ul class="pagination">
					
					<c:if test="${paging.currentPageNo gt 5 }">
						<li><a href="javascript:goPage(${paging.prevPageNo},${paging.maxPost })">이전</a></li>
					</c:if>
					
					<c:forEach var="i" begin="${paging.startPageNo }" end="${paging.endPageNo }" step="1">
						<c:choose>
							
							<c:when test="${i eq paging.currentPageNo }">
								<li class="active"><a href="javascript:goPage(${i },${paging.maxPost })">${i }</a></li>
							</c:when>
							
							<c:otherwise>
								<li><a href="javascript:goPage(${i },${paging.maxPost })">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					
					<fmt:parseNumber var="currentPage" integerOnly="true" value="${(paging.currentPageNo-1) / 5 }" />
					<fmt:parseNumber var="finalPage" integerOnly="true" value="${(paging.finalPageNo-1) / 5 }" />
					 <c:if test="${currentPage < finalPage }">
						<li><a href="javascript:goPage(${paging.nextPageNo },${paging.maxPost })">다음</a></li>
					</c:if>
				</ul>
			</div>
		</c:when>
	</c:choose>
	
	<c:if test="${not empty sessionScope.id}">
		<a href = "write.do?boardno=${boardno}" class="btn btn-default">글쓰기 </a>
	</c:if>
</div>
</body>
</html>

<!-- 다음 페이지로 가는 함수. -->
<script>
	function goPage(pages,lines){
		location.href='?' + "pages=" + pages;
	}
</script>