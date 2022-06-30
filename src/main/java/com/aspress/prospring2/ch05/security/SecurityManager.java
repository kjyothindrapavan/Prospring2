package com.aspress.prospring2.ch05.security;

public class SecurityManager {
	private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();
	
	public void login(String userName, String password) {
		//assume all credentials are valid for login
		threadLocal.set(new UserInfo(userName,password));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public UserInfo getLoggedOnUser() {
		return threadLocal.get();
	}
}
