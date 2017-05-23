package com.roy.database;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable{
	private Integer id;
	private Integer titleid;
	private String user_account;
	private String comment;
	private Timestamp date;
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTitleid() {
		return titleid;
	}
	public void setTitleid(Integer titleid) {
		this.titleid = titleid;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	private Timestamp commentDate;

}
