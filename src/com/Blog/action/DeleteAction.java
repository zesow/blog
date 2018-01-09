package com.Blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;
import com.Blog.dao.BoardDao;

import java.sql.*;
public class DeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		
		BoardDao.getInstance().deleteArticle(idx);
		return "list.do";
	}

}
