package com.Blog.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.beans.Board;
import com.Blog.beans.Comment;
import com.Blog.controller.CommandAction;
import com.Blog.dao.BoardDao;
import com.Blog.dao.CommentDao;

import java.sql.*;
import java.util.ArrayList;
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		Board article = BoardDao.getInstance().getArticle(idx);
		
		ArrayList<Comment> commentList = CommentDao.getInstance().getCommentList(Integer.parseInt(idx));
		System.out.println("size" + commentList.size());
		if(commentList.size() > 0)
			request.setAttribute("commentList", commentList);
		
		request.setAttribute("article", article);
		return "view/board/content.jsp";
	}

}
