package com.roy.database;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户持久化类
 * @author Roy
 * @date: 2017年5月5日  下午6:54:23
 * version:
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userEmail;
	private String userGender;
	private Date userBirthday;
	private Timestamp operTime;
	private String isdel;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassWord) {
		this.userPassword = userPassWord;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}
	public Timestamp getOperTime() {
		return operTime;
	}
	public String getIsdel() {
		return isdel;
	}
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}
}
