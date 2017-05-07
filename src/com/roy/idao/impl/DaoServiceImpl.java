package com.roy.idao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.roy.idao.IDaoService;

public class DaoServiceImpl implements IDaoService {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 打开并返回一个数据库的会话
	 * @return
	 */
	public Session getSession(){
		return sessionFactory.openSession();
	}

	@Override
	public List<? extends Object> query(String hql) throws Exception {
		// TODO Auto-generated method stub
		//获取一个数据库会话对象
		Session session = getSession();
		//创建查询数据对象
		Query query = session.createQuery(hql);
		//查询返回数据集合
		List<? extends Object> list = query.list();
		//关闭会话
		session.close();
		return list;
	}

	@Override
	public void save(Object object) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//对象与session绑定
		session.save(object);
		//提交事务
		transaction.commit();
		session.flush();
		//关闭session
		session.close();
	}

	@Override
	public void update(Object object) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Object... objects) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		for(Object object : objects){
			//虚拟删除
			session.update(object);
		}
		transaction.commit();
		session.close();
	}

}
