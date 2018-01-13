package com.Blog.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Blog.controller.CommandAction;
import com.Blog.dao.BoardDao;

import java.sql.*;
import com.Blog.beans.Board;
import java.util.ArrayList;

public class ListAction implements CommandAction{

	private int com_to_boardno(String command) {
		int result = 0;
		if(command.equals("/projectsList.do"))
			result = 1;
		else if(command.equals("/algorithmList.do"))
			result = 2;
		else if(command.equals("/financeList.do"))
			result = 3;
		else if(command.equals("/taxList.do"))
			result = 4;
		else if(command.equals("/photoList.do"))
			result = 5;
		else if(command.equals("/foodList.do"))
			result = 6;
		
		return result;
	}
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath()) == 0) {
//			contextpath 다음부터 되돌려줌. /Blog/list.do -> /list.do
			command = command.substring(request.getContextPath().length());
		}
		int boardno = com_to_boardno(command);
		ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(boardno);
		request.setAttribute("articleList",articleList);
		request.setAttribute("boardno", boardno);
			
		return "view/board/list.jsp";
	}
	
}
