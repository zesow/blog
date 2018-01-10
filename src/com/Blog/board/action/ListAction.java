package com.Blog.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;
import com.Blog.dao.BoardDao;

import java.sql.*;
import com.Blog.beans.Board;
import java.util.ArrayList;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		ArrayList<Board> articleList = BoardDao.getInstance().getArticleList();
		request.setAttribute("articleList",articleList);
			
		return "view/board/list.jsp";
	}
	
}
