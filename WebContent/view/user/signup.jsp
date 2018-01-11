<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 </title>
<%@ include file="../partial/head.jsp" %>
</head>
<body>
	<%@ include file="../partial/navbar.jsp" %>
  <div class="container user user-new">

   <form class="user-form form-horizontal" action="signup.do" method="post">
    <div class="contentBox">
     <h3 class="contentBoxTop">New User</h3>
     <fieldset>
      <div class="form-group">
       <label for="username" class="col-sm-3 control-label">Username*</label>
       <div class="col-sm-9">
        <input class="form-control" type="text" id="username" name="id" value="">
       </div>
      </div>
      <div class="form-group">
       <label for="name" class="col-sm-3 control-label">Name*</label>
       <div class="col-sm-9">
        <input class="form-control" type="text" id="name" name="name" value="">
       </div>
      </div>
      <div class="form-group">
       <label for="email" class="col-sm-3 control-label">Email</label>
       <div class="col-sm-9">
        <input class="form-control" type="text" id="email" name="mail" value="">
       </div>
      </div>
      <div class="form-group">
       <label for="password" class="col-sm-3 control-label">Password*</label>
       <div class="col-sm-9">
        <input class="form-control" type="password" id="password" name="passwd" value="">
       </div>
      </div>
      <div class="form-group">
       <label for="passwordConfirmation" class="col-sm-12 control-label">Password Confirmation*</label>
       <div class="col-sm-9 col-sm-offset-3">
        <input class="form-control" type="password" id="passwordConfirmation" name="passwdConfirmation" value="">
       </div>
      </div>
      <p>
       <small>*Required</small>
      </p>
     </fieldset>
    </div>
    <div class="buttons">
     <button type="submit" class="btn btn-default">Submit</button>
    </div>
   </form>

  </div> <!-- container end -->
 </body>
</html>