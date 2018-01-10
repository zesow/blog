package com.Blog.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.beans.Board;
import com.Blog.controller.CommandAction;
import com.Blog.dao.BoardDao;

import java.util.regex.Pattern;
import java.sql.*;
public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		if(title == "" ||title == null) System.out.println("title이 null입니다.");
		 
		if(writer == "" ||writer == null)
		    System.out.println("writer가 null입니다.");   
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
		    System.out.println("이메일 형식이 아닙니다.");
		 
		if(content == "" ||content == null) System.out.println("content가 null입니다.");
		
		Board article = new Board();
		article.setTitle(title);
		article.setWriter(writer);
		article.setContent(content);
		BoardDao.getInstance().setArticle(article);
		
		return "list.do";
	}

}
