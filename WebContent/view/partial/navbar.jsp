<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<nav class="navbar navbar-default">
 <div class="container">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <div class="navbar-header">
   <a class="navbar-brand" href="/">Gus' Blog</a>
   </div>
  </div>
  <div class="collapse navbar-collapse" id="myNavbar">
   <ul class="nav navbar-nav">
    <li><a href="/about">Who is Gus?</a></li>
    <li class="dropdown">
    		<a class="dropdown-toggle" data-toggle="dropdown" href="/about">Coding<span class="caret"></span></a>
    		<ul class="dropdown-menu">
    			<li><a href="projectsList.do">Projects</a></li>
    			<li><a href="algorithmList.do">Algorithm</a></li>
    		</ul>
    </li>
    <li class="dropdown">
    		<a class="dropdown-toggle" data-toggle="dropdown" href="/about">Finance & law<span class="caret"></span></a>
    		<ul class="dropdown-menu">
    			<li><a href="financeList.do">경제상식 </a></li>
    			<li><a href="taxList.do">세금 이야기 </a></li>
    		</ul>
    </li>
    <li class="dropdown">
    		<a class="dropdown-toggle" data-toggle="dropdown" href="/about">Life<span class="caret"></span></a>
    		<ul class="dropdown-menu">
    			<li><a href="photoList.do">사진 </a></li>
    			<li><a href="foodList.do">맛집 </a></li>
    		</ul>
    </li>
   </ul>
   <ul class="nav navbar-nav navbar-right">
  
   <%if(session.getAttribute("id") == null) {%>
      <li><a href="signupView.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginView.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
   <%}else{%>
      <li><a href="correctView.do"><span class="glyphicon glyphicon-eye-open"></span> My Account</a></li>
      <li><a href="logout.do"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
   <%} %>
   </ul>
  </div>
  
 </div>
</nav>
</body>
</html>