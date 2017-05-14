package com.roy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.Question;
import com.roy.service.IQuestionService;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 用户问题管理控制类
 * @author Roy
 * @date: 2017年5月12日  下午9:44:42
 * version:
 */
public class QuestionAction extends ActionSupport{
	private HttpServletRequest request;
	private HttpServletResponse response;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	private Question question;
	private IQuestionService iquestionService;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public IQuestionService getIquestionService() {
		return iquestionService;
	}
	public void setIquestionService(IQuestionService iquestionService) {
		this.iquestionService = iquestionService;
	}
	
	/**
	 * 添加问题 
	 * @return
	 */
	public String add() {
		try {
			iquestionService.add(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新问题信息
	 * @return
	 */
	public String update() {
		try {
			iquestionService.update(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	/**
	 * 删除问题
	 * @return
	 */
	public String delete() {
		try {
			iquestionService.delete(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	/**
	 * ajax显示问题
	 * 此处显示最多5个问题，不足5个的时候则全部显示
	 */
	public void show() {
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			List<Question> list = iquestionService.query();
			List<JSONObject> jlist = new ArrayList<JSONObject>();
			if (list.size() < 5) {
				for(Question question : list){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("title", question.getTitle());
					jsonObject.put("content", question.getContent());
					jsonObject.put("user", question.getUserAccount());
					jsonObject.put("date", question.getQuestionDate());
					jlist.add(jsonObject);
				}
			}else {
				for(int i = 0; i < 5;i++){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("title", list.get(i).getTitle());
					jsonObject.put("content", list.get(i).getContent());
					jsonObject.put("user", list.get(i).getUserAccount());
					jsonObject.put("date", list.get(i).getQuestionDate());
					jlist.add(jsonObject);
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(jlist);
			response.getWriter().println(jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
