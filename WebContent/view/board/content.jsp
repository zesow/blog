<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../partial/head.jsp" %>
<title>Insert title here</title>

</head>
<body>
<%@ include file="../partial/navbar.jsp" %>
<div class="container">
<div class="col-md-12">
	<div class="page-header">
		<h3>${article.title }</h3>	
	</div>
</div>

<div class="panel panel-default">
<div class="panel-heading">
	<h4 class="panel-title">
		글쓴이: ${article.writer} &nbsp; 등록일: ${article.regdate} &nbsp; 조회수: ${article.count }
	</h4>
</div>
<div class="panel-body">
	<div class="content post" style="line-height:30px;" >
	${article.content }
	</div>
</div>
</div>

<!-- 댓글. -->
<div id="comment">
<!-- 댓글 목록. -->
<c:if test="${requestScope.commentList != null }">
	<c:forEach var="comment" items="${requestScope.commentList }">
		<div class = "col-md-12 comment">
			<div class = "panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a>${comment.comment_id }</a>
						<a>${comment.comment_date }</a>
						
						<c:if test="${sessionScope.id != null }">
						<div class="pull-right">
							<a href="#">답변</a>
							<c:if test="${comment.comment_id == sessionScope.id }">
								<!-- <a href="commentUpdateAction.do">수정</a> -->
								<a href="#" onclick="deleteCmt(${comment.comment_num })">삭제</a>
							</c:if>
						</div>
						</c:if>
						
					</h4>
				</div>
				
				<div class="panel-body">
					<div class="content" style="line-height:30px;">
						<p>${comment.comment_content }</p>
					</div>
				</div>
			</div>		
		</div>
	</c:forEach>
</c:if>

<!-- 댓글 작성. -->
<c:if test="${sessionScope.id != null }">
	<form id="writeCommentForm" onsubmit="writeCmt();">
		<input type="hidden" name="comment_board" value="${article.idx }">
		<input type="hidden" name="comment_id" value="${sessionScope.id}">
		<div class="form-group">
			<label for="text">${sessionScope.id}</label>
			<textarea name="comment_content" rows="4" cols="100"></textarea>
		</div>
		<button type="submit" class="btn btn-default">댓글쓰기</button>
	</form>
</c:if>

</div>

<c:if test="${article.writer == sessionScope.id }">
	<a href = "delete.do?idx=${article.idx}" class="btn btn-default">삭제  </a>
	<a href = "correct.do?idx=${article.idx}" class="btn btn-default">수정 </a>
</c:if>
<a href = "javascript:history.back();" class="btn btn-default">목록 </a>
</div>
</body>
</html>

<script type="text/javascript">
	var httpRequest = null;
	
	// 자바스크립트를 이용하여 서버로 보내는 http request 만들기.
	function getXMLHttpRequest(){
		var httpRequest = null;
		
		if(window.ActiveXObject){ // IE
			try{
				httpRequest = new ActiveXObject("Msxm12.XMLHTTP");
			}catch(e){
				try{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					httpRequest = null;
				}
			}
		}
		else if(window.XMLHttpRequest){ // safari
			httpRequest = new window.XMLHttpRequest();
		}
		
		return httpRequest;
	}
	
	function writeCmt(){
		
		var form = document.getElementById("writeCommentForm");
		
		var board = form.comment_board.value;
		var id = form.comment_id.value;
		var content = form.comment_content.value;
		
		if(!content){
			alert("내용을 입력하세요.");
			return false;
		}
		else{
			var param="comment_board="+board+"&comment_id="+id+"&comment_content="+content;
			
			// 1단계. http request 만들기.
			httpRequest = getXMLHttpRequest();
			// 서버로 보낸 요청에 대한 응답을 받았을 때 어떤 동작을 할 것인지.
			httpRequest.onreadystatechange =checkFunc;
			// 실질적으로 서버에 request 함.
			httpRequest.open("POST","commentWriteAction.do",true);
			httpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=UTF-8');
			httpRequest.send(param);
		}
	}
	
	function checkFunc(){
		// 2단계. 서버 응답에 대한 처리. 4는 서버로부터 모든 응답을 받았다는 뜻.
		if(httpRequest.readyState == 4){
			document.location.reload();
		}
	}
	
	function deleteCmt(comment_num){
		var param = "comment_num=" + comment_num;
		// 1단계. http request 만들기.
		httpRequest = getXMLHttpRequest();
		// 서버로 보낸 요청에 대한 응답을 받았을 때 어떤 동작을 할 것인지.
		httpRequest.onreadystatechange =checkFunc;
		// 실질적으로 서버에 request 함.
		httpRequest.open("POST","commentDeleteAction.do",true);
		httpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=UTF-8');
		httpRequest.send(param);
	
	}
		
</script>