package com.Blog.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Blog.beans.User;
import com.Blog.controller.CommandAction;
import com.Blog.dao.UserDao;

public class LoginAction implements CommandAction{

	HttpSession session = null;
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		session = request.getSession();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		int result = UserDao.getInstance().isAuthenticate(id,passwd);
		
		if(result == -1) { //아이디 없음.
			System.out.println("아이디가 없습니다.");
		}
		else if(result == 0) { // 비밀번호 틀림.
			System.out.println("비밀번호가 틀립니다.");
		}
		else { // 로그인 완료.
			System.out.println("로그인에 성공했습니다.");
			session.setAttribute("id", id);
			session.setAttribute("passwd", passwd);
		}
		
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
