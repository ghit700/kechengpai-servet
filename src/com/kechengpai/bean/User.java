package com.kechengpai.bean;

public class User {
	protected String account;
	protected String password;
	protected String school;
	protected String name;
	protected int type;
	
	
	
	public User(String account, String password, String school, String name,
			int type) {
		super();
		this.account = account;
		this.password = password;
		this.school = school;
		this.name = name;
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
