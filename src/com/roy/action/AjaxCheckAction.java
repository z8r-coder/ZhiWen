package com.roy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.User;
import com.roy.service.IUserService;
public class AjaxCheckAction extends ActionSupport{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IUserService iuserService;
	
	
	public IUserService getIuserService() {
		return iuserService;
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}

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
	
	/**
	 * ajax检查账号是否被占用
	 * @throws Exception
	 */
	public void ajaxCheck() throws Exception {
		// TODO Auto-generated method stub
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String userAccount = request.getParameter("user.userAccount");
		List<User> list = iuserService.query(userAccount);
		if (list == null || list.size() == 0) {
			response.getWriter().println("true");
		}else {
			response.getWriter().println("false");
		}
	}
}
