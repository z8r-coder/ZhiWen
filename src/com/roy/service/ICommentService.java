package com.roy.service;

import java.util.List;

import com.roy.database.Comment;
import com.roy.database.Question;
import com.roy.database.User;

public interface ICommentService {
	/**
	 * 查询一个用户的所有评论
	 * @return
	 */
	public List<Comment> query(User user) throws Exception;
	
	/**
	 * 查询一个问题下的所有评论
	 * @param question
	 * @return
	 */
	public List<Comment> query(int titleid) throws Exception;
	/**
	 * 添加评论
	 * @param comment
	 */
	public void add(Comment comment) throws Exception;
	/**
	 * 删除评论
	 * @param comment
	 */
	public void delete(Comment comment) throws Exception;
	/**
	 * 更新评论
	 * @param comment
	 */
	public void update(Comment comment) throws Exception;
}
