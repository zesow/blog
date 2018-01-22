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
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		String uri = null;
		
		if(boardno == 0)
			uri = "list.do";
		else if(boardno == 1)
			uri = "projectsList.do";
		else if(boardno == 2)
			uri = "algorithmList.do";
		else if(boardno == 3)
			uri = "financeList.do";
		else if(boardno == 4)
			uri = "taxList.do";
		else if(boardno == 5)
			uri = "photoList.do";
		else if(boardno == 6)
			uri = "foodList.do";
		
		return "index.jsp";
	}

}
