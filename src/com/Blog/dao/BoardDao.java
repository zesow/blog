package com.Blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.Blog.beans.Board;

public class BoardDao extends CommonDao{
	
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		_instance.SetDB();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList(int boardno,int offset, int maxPost) throws SQLException{
		  
		@SuppressWarnings("unchecked")  		 
		ArrayList<Board> articleList = null;

		
		// ibatis에 파라미터 여러개 보내기 위해선 map으로 감싸서 보내야 함.
		HashMap<String,Object> params = new HashMap<>();
		params.put("boardno", boardno);
		params.put("offset", offset);
		params.put("maxPost", maxPost);
		
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", params); 
		return articleList;

	}

	public Board getArticle(String idx) throws SQLException{

		@SuppressWarnings("unchecked")
		Board article = null;
		article = (Board)GetDB().queryForObject("getArticle", idx);
		return article;
	}
	
	public void setArticle(Board article) throws SQLException{
                     
		GetDB().insert("setArticle", article);
	}
	
	public void deleteArticle(String idx) throws SQLException{
		
		GetDB().delete("deleteArticle", idx);
	}
	
	public void correctArticle(Board article) throws SQLException{

		GetDB().update("correctArticle", article);
	}

	public int getCount(int boardno) throws SQLException {
		// TODO Auto-generated method stub
		int count = (int)GetDB().queryForObject("getCount",boardno);
		return count;
	}
	
}
