package com.example.demo.dto;

public class MemberDto {
	private String userId;
	private String userPw;
	private String phone;
	private String email;

	public MemberDto(String userId, String userPw, String phone, String email) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.phone = phone;
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPw=" + userPw + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
