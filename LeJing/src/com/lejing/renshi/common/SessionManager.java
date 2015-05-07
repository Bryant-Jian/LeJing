package com.lejing.renshi.common;

public class SessionManager {

	private static SessionManager instance = new SessionManager();
	private String token;
	private String username;
	private String password;
	private String appVersion;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	public boolean logined(){
		if(this.token != null && !this.token.equals("")){
			return true;
		}
		return false;
	}

	private SessionManager() {
		super();
	}

	public static SessionManager getInstance() {
		return instance;
	}
	
}
