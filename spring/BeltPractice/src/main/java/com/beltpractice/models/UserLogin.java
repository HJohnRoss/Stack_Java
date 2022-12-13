package com.beltpractice.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLogin {

	@NotEmpty(message = "Email is required")
	@Email(message = "please enter a valid email")
	private String email;

	@NotEmpty(message = "Password is required")
	@Size(message = "Password must be at least 8 characters long")
	private String password;

	public UserLogin() {}

	
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
}
