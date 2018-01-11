package com.Blog.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.beans.User;
import com.Blog.controller.CommandAction;
import com.Blog.controller.HttpUtil;
import com.Blog.dao.UserDao;

public class SignupAction implements CommandAction{

	public boolean checkForm(String id,String passwd,String passwdConfirmation,String name,String mail,HttpServletRequest request, HttpServletResponse response) {
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력해 주세요! ");
			HttpUtil.forward(request, response, "signupView.do");
			return false;
		}
		
		if(!passwd.equals(passwdConfirmation)) {
			request.setAttribute("error", "pw와 pw확인을 일치해 주세요! ");
			HttpUtil.forward(request, response, "signupView.do");
			return false;
		}
		return true;
	}
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String passwdConfirmation = request.getParameter("passwdConfirmation");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		checkForm(id,passwd,passwdConfirmation,name,mail,request,response);
		
		
		User user = new User();
		user.setId(id);
		user.setPasswd(passwd);
		user.setName(name);
		user.setMail(mail);
		
		UserDao.getInstance().setUser(user);
		return "list.do";
	}

}
