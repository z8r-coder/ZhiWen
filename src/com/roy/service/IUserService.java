package com.roy.service;
import java.util.List;

import com.roy.database.User;
/**
 * 用户业务管理接口
 * @author Roy
 * @date: 2017年5月6日  上午11:22:34
 * version:
 */
public interface IUserService {
	/**
	 * 查询用户并返回数据
	 * @return
	 */
	public List<User> query(String account) throws Exception;
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void update(User user) throws Exception;
	
	/**
	 * 删除选中用户
	 * @param ids
	 */
	public void delete(int...ids) throws Exception;
	
	/**
	 * 增添新用户
	 * @param user
	 * @throws Exception
	 */
	public void add(User user) throws Exception;
}
