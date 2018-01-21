package com.Blog.comment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;
import com.Blog.dao.CommentDao;

public class CommentDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String comment_num = request.getParameter("comment_num");
		
		CommentDao.getInstance().deleteComment(Integer.parseInt(comment_num));
		
		return null;
	}

}
