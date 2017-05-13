package com.roy.database;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 提问信息相关持久化类
 * @author Roy
 * @date: 2017年5月12日  下午8:16:53
 * version:
 */
public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userAccount;
	private String title;
	private String content;
	private Timestamp questionDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(Timestamp questionDate) {
		this.questionDate = questionDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
