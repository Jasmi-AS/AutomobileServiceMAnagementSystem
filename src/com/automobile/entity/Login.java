package com.automobile.entity;

public class Login {
	public int loginId;
	public String userName;
	public String password;

	public Login() {
		super();
	}

	public Login(int loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserNAme() {
		return userName;
	}

	public void setUserNAme(String userNAme) {
		this.userName = userNAme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
