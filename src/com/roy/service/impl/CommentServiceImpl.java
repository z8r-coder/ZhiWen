package com.roy.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.roy.database.Comment;
import com.roy.database.Question;
import com.roy.database.User;
import com.roy.idao.IDaoService;
import com.roy.service.ICommentService;

public class CommentServiceImpl implements ICommentService{
	private IDaoService idaoService;
	public IDaoService getIdaoService() {
		return idaoService;
	}

	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}

	@Override
	public List<Comment> query(User user) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) idaoService.query("from Comment where user_account='" + user.getUserAccount()
							+ "'");
		return list;
	}

	@Override
	public List<Comment> query(int titleid) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) idaoService.query("from Comment where titleid=" + titleid);
		return list;
	}

	@Override
	public void add(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		comment.setDate(new Timestamp(System.currentTimeMillis()));
		idaoService.save(comment);
	}

	@Override
	public void delete(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
