package com.roy.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.roy.database.Question;
import com.roy.database.User;
import com.roy.idao.IDaoService;
import com.roy.idao.IQuestionDaoService;
import com.roy.idao.impl.QuestionDaoServiceImpl;
import com.roy.service.IQuestionService;

/**
 * 问题管理业务实现类
 * 
 * @author Roy
 * @date: 2017年5月12日 下午8:59:02 version:
 */
public class QuestionServiceImpl implements IQuestionService {
	private IQuestionDaoService iquestiondaoService;

	public IQuestionDaoService getIquestiondaoService() {
		return iquestiondaoService;
	}

	public void setIquestiondaoService(IQuestionDaoService iquestiondaoService) {
		this.iquestiondaoService = iquestiondaoService;
	}

	@Override
	public List<Question> query(String title) throws Exception {
		// TODO Auto-generated method stub
		List<Question> list = (List<Question>) iquestiondaoService
				.query("from Question where " + "title='" + title + "'");
		return list;
	}

	@Override
	public List<Question> query(User user) throws Exception {
		// TODO Auto-generated method stub
		List<Question> list = (List<Question>) iquestiondaoService
				.query("from Question where " + "user_account='" + user.getUserAccount() + "'");
		return list;
	}

	@Override
	public void update(Question question) throws Exception {
		// TODO Auto-generated method stub
		question.setQuestionDate(new Timestamp(System.currentTimeMillis()));
		iquestiondaoService.update(question);
	}

	@Override
	public void add(Question question) throws Exception {
		// TODO Auto-generated method stub
		question.setQuestionDate(new Timestamp(System.currentTimeMillis()));
		iquestiondaoService.save(question);
	}

	@Override
	public void delete(Question question) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Question where user_account='" + question.getUserAccount() +"' and "
				+ "title='" + question.getTitle() + "'";
		List<Question> list = (List<Question>)iquestiondaoService.query(hql);
		
		//获得对象数组
		Object objects = list.toArray();
		iquestiondaoService.delete(objects);
	}

}
