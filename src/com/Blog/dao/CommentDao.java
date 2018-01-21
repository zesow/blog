package com.Blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Blog.beans.Comment;

public class CommentDao extends CommonDao{
	public static CommentDao getInstance() {
		CommentDao _instance = new CommentDao();
		_instance.SetDB();
		return _instance;
	}

	public boolean setComment(Comment comment) throws SQLException {
		// TODO Auto-generated method stub
		boolean result =false;
		
		GetDB().insert("setComment", comment);
		return false;
	}
	
	public ArrayList<Comment> getCommentList(int comment_board) throws SQLException{
		ArrayList<Comment> list = null;
		list = (ArrayList<Comment>)GetDB().queryForList("getCommentList", comment_board);
		
		return list;
	}
	
	public void updateComment(Comment comment) {
		
	}
	
	public void deleteComment(int comment_num) throws SQLException {
		GetDB().delete("deleteComment", comment_num);
	}
}
