package com.Blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Blog.beans.Board;

public class BoardDao extends CommonDao{
	
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		_instance.SetDB();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList(int boardno) throws SQLException{
		  
		@SuppressWarnings("unchecked")  		 
		ArrayList<Board> articleList = null;
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", boardno); 
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
	
}
