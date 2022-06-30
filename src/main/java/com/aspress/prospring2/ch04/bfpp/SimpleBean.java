package com.aspress.prospring2.ch04.bfpp;

public class SimpleBean {
	private String connectionString;
	private String password;
	private String userName;
	
	public String getConnectionString() {
		return connectionString;
	}
	
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleBean");
		sb.append("{password='").append(this.password).append('\'');
		sb.append(", username='").append(this.userName).append('\'');
		sb.append(", connectionString='").append(this.connectionString).append('\'');
		sb.append('}');
		
		return sb.toString();
	}
	
	

}
