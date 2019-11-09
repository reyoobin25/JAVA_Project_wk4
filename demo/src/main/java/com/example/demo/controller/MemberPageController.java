package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MemberManagerImpl;

@Controller
public class MemberPageController {
	
	@Autowired
	private MemberManagerImpl memberManagerImpl;
	
	
	//로그인 페이지
	@RequestMapping("/loginForm.html")
	public String loginForm() {
		return "loginForm";
	}
	
	//회원가입 페이지
	@RequestMapping("/joinForm.html")
	public String joinForm() {
		return "joinForm";
	}
	
	//로그아웃
	@GetMapping(value = "/logoutAction")
	public String logout(HttpServletRequest request) {
			request.getSession().removeAttribute("user_id");
			request.getSession().removeAttribute("user_pw");
			return "index";
	}

}
