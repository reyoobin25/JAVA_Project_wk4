package com.example.demo.vo;

public class MemberVO {
	private String user_id;
	private String user_pw;
	private String phone;
	private String email;
	private String register;
	
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String user_id, String user_pw, String phone, String email) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.phone = phone;
		this.email = email;
	}
	
	public MemberVO(String user_id, String user_pw, String phone, String email, String register) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.phone = phone;
		this.email = email;
		this.register = register;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
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
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	
	
	
	
}
