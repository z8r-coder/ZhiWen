package com.roy.service;

import java.util.List;

import com.roy.database.Question;
import com.roy.database.User;

/**
 * 提问管理接口
 * @author Roy
 * @date: 2017年5月12日  下午8:49:35
 * version:
 */
public interface IQuestionService {
	
	/**
	 * 查询全部
	 * @return
	 * @throws Exception
	 */
	public List<Question> query() throws Exception;
	/**
	 * 根据标题来查询提问内容
	 * @param title
	 * @return
	 */
	public List<Question> query(String title) throws Exception;
	
	/**
	 * 根据用户来查询提问内容
	 * @param user
	 * @return
	 */
	public List<Question> query(User user) throws Exception;
	
	/**
	 * 更新问题
	 * @param question
	 */
	public void update(Question question) throws Exception;
	
	/**
	 * 增添新问题
	 * @param question
	 */
	public void add(Question question) throws Exception;
	/**
	 * 删除问题
	 * @param question
	 */
	public void delete(Question question) throws Exception;
}
