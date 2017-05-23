package com.roy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.Comment;
import com.roy.database.Question;
import com.roy.service.ICommentService;
import com.roy.service.IQuestionService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CommentAction extends ActionSupport {
	private ICommentService icommentService;
	private IQuestionService iquestionService;
	private Comment comment;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public ICommentService getIcommentService() {
		return icommentService;
	}

	public void setIcommentService(ICommentService icommentService) {
		this.icommentService = icommentService;
	}
	
	public String add() {
		try {
			icommentService.add(comment);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public void show(){
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");
		try {
			
			List<JSONObject> jlist = new ArrayList<JSONObject>();
			System.out.println(request.getParameter("comment.titleid"));
			//int titleid = Integer.parseInt(request.getParameter("comment.titleid"));
			//System.out.println(titleid);
			JSONArray jsonArray = JSONArray.fromObject(jlist);
			response.getWriter().println(jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
