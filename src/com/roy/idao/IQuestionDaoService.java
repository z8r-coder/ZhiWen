package com.roy.idao;

import java.util.List;

/**
 * 问题数据访问接口
 * @author Roy
 * @date: 2017年5月13日  下午7:39:50
 * version:
 */
public interface IQuestionDaoService {
	/**
	 * 查询数据
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<? extends Object> query(String hql) throws Exception;
	
	/**
	 * 保存对象
	 * @param object
	 * @throws Exception
	 */
	public void save(Object object) throws Exception;
	
	/**
	 * 修改对象
	 * @param object
	 * @throws Exception
	 */
	public void update(Object object) throws Exception;
	
	/**
	 * 删除对象
	 * @param objects
	 * @throws Exception
	 */
	public void delete(Object...objects) throws Exception;

}
