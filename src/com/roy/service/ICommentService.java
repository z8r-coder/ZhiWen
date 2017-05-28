package com.roy.service;

import java.util.List;

import com.roy.database.Comment;
import com.roy.database.PageBean;
import com.roy.database.Question;
import com.roy.database.User;

public interface ICommentService {
	/**
	 * 查询一个用户的所有评论
	 * @return
	 */
	public List<Comment> query(User user) throws Exception;
	/**
	 * 获取相应的pageBean
	 * @param titleid
	 * @return
	 * @throws Exception
	 */
	public PageBean getPageBean(int titleid) throws Exception;
	/**
	 * 查询一个问题下的所有评论
	 * @param question
	 * @return
	 */
	public List<Comment> query(int titleid) throws Exception;
	/**
	 * 分页查询
	 * @param titleid
	 * @param pageSize
	 * @return
	 */
	public List<Comment> query(int titleid, int pageSize) throws Exception;
	/**
	 * 获取评论总数
	 * @param titleid
	 * @return
	 * @throws Exception
	 */
	public int getCount(int titleid) throws Exception;
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
