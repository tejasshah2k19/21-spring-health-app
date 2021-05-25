package com.bean;

public class UserBean {

	int userId;
	String email;
	String password;
	String firstName;
	int role;

	public enum Role {
		ADMIN(1), USER(2);
		int value;

		Role(int v) {
			value = v;
		}
		
		public int  getRole() {
			return value;
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
