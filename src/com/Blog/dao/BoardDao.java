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
		
		return _instance;
	}
	
	public ArrayList<Board> getArticleList() throws SQLException{
		ArrayList<Board> articleList = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "SELECT * FROM board ORDER BY idx DESC";
		
		rs = openConnection().executeQuery(sql);
		
		while(rs.next()) {
			Board article = new Board();
			
			article.setIdx(rs.getInt("idx"));
			article.setTitle(rs.getString("title"));
			article.setWriter(rs.getString("writer"));
			article.setRegdate(rs.getString("regdate"));
			article.setCount(rs.getInt("count"));
			
			articleList.add(article);
		}
		
		closeConnection();
		return articleList;
	}
	
	public Board getArticle(String idx) throws SQLException{
		Board article = new Board();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board WHERE idx=" + idx ;
		rs = openConnection().executeQuery(sql);
		while(rs.next()) {
			
			article.setIdx(rs.getInt("idx"));
			article.setTitle(rs.getString("title"));
			article.setWriter(rs.getString("writer"));
			article.setRegdate(rs.getString("regdate"));
			article.setCount(rs.getInt("count"));
			article.setContent(rs.getString("content"));
			
		}
		
		closeConnection();
		
		return article;
		
	}
	
	public void setArticle(Board article) throws SQLException{
                     
			String sql = "INSERT INTO board" + " (TITLE,WRITER,REGDATE,COUNT,CONTENT)" +
						" VALUES ('" + article.getTitle() + "', '" + article.getWriter() + "', " + "NOW()" + ", '" + 1 + "', '" + article.getContent() + "')";
	
			
			openConnection().executeUpdate(sql);
			closeConnection();
	}
	
	public void deleteArticle(String idx) throws SQLException{
		
		String sql = "DELETE FROM board WHERE idx=" + idx ;
		openConnection().executeUpdate(sql);
	}
	
	public void correctArticle(Board article) throws SQLException{
		String sql = "UPDATE board SET title='" + article.getTitle() + "' , writer='" + article.getWriter() + "' , content='" + article.getContent() + "' WHERE idx=" + article.getIdx();

		openConnection().executeUpdate(sql);
		closeConnection();
	}
}
