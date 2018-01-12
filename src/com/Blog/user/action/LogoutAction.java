package com.Blog.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Blog.controller.CommandAction;

public class LogoutAction implements CommandAction{
	
	HttpSession session = null;
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		session = request.getSession();
		session.invalidate();
		
		return "list.do";
	}

}
