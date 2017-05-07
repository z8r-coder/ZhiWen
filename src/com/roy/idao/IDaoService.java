package com.roy.idao;

import java.util.List;

/**
 * 数据访问公共接口
 * @author Roy
 * @date: 2017年5月5日  下午7:25:19
 * version:
 */
public interface IDaoService {
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
