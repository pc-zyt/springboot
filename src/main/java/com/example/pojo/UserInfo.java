package com.example.pojo;

import java.util.Date;

public class UserInfo {
	private String userId;
	private String password;
	private String name;
	private String sex;
	private int age;
	private int pwdErrorNum;
	private int role;
	private int isLock;
	private Date updateDate;
	private Date modifypwdDate;
	private Date createDate;
	private String creator;
	private int version;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPwdErrorNum() {
		return pwdErrorNum;
	}

	public void setPwdErrorNum(int pwdErrorNum) {
		this.pwdErrorNum = pwdErrorNum;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getIsLock() {
		return isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getModifypwdDate() {
		return modifypwdDate;
	}

	public void setModifypwdDate(Date modifypwdDate) {
		this.modifypwdDate = modifypwdDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String toString() {
		return "{UserInfo:[userId:"+userId+"password:"+password+"name:"+name+"sex:"+sex
				+"age:"+age+"pwdErrorNum:"+pwdErrorNum+"role:"+role+"isLock:"+isLock
				+"updateDate:"+updateDate+"modifypwdDate:"+modifypwdDate+"createDate:"
				+createDate+"version"+version+"]}";
	}
}
