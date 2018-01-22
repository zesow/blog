<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 </title>
<%@ include file="../partial/head.jsp" %>
</head>
<body>
<%@ include file="../partial/navbar.jsp" %>
  <div class="container home home-login">

   <form class="login-form form-horizontal" action="login.do" method="post">
   	<input type=hidden name="boardno" value=${param.boardno }>
    <div class="contentBox">
     <h3 class="contentBoxTop">Login</h3>
     <fieldset>
      <div class="form-group ">
       <label for="username" class="col-sm-3 control-label">Username</label>
       <div class="col-sm-9">
        <input class="form-control" type="text" id="username" name="id" value="">
       </div>
      </div>
      <div class="form-group">
       <label for="password" class="col-sm-3 control-label">Password</label>
       <div class="col-sm-9">
        <input class="form-control" type="password" id="password" name="passwd" value="">
         <span class="help-block"></span>
       </div>
      </div>
       <div class="has-error">
        <span class="help-block"></span>
       </div>
     </fieldset>
    </div>
    <div class="buttons">
     <input class="btn btn-default" type="submit" value="Submit">
    </div>
   </form>

  </div> <!-- container end -->
 </body>
</html>