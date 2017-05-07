package com.roy.service.impl;
import java.sql.Timestamp;
import java.util.List;

import com.roy.database.User;
import com.roy.idao.IDaoService;
import com.roy.service.IUserService;;
/**
 * 用户管理业务具体实现类
 * @author Roy
 * @date: 2017年5月6日  上午11:38:06
 * version:
 */
public class UserServiceImpl implements IUserService{
	private IDaoService idaoService;
	
	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}
	public IDaoService getIdaoService() {
		return idaoService;
	}
	
	/**
	 * 获取查询结果
	 */
	@Override
	public List<User> query(String account) throws Exception {
		// TODO Auto-generated method stub
		//通过公共数据访问接口查询数据
		List<User> list = (List<User>) idaoService.query("from User "
				+ "where " + "user_account='" + account + "'");
		return list;
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setIsdel("0");
		user.setOperTime(new Timestamp(System.currentTimeMillis()));
		idaoService.update(user);
	}

	@Override
	public void delete(int... ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		//封装通用字段
		user.setIsdel("0");
		user.setOperTime(new Timestamp(System.currentTimeMillis()));
		//访问数据库，保存值
		idaoService.save((Object)user);
	}
	
}
