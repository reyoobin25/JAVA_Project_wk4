package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberManagerImpl;

@RestController
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberManagerImpl memberManagerImpl;
	
	@PostMapping("/joinAction")
	public int join(@RequestBody MemberDto memberDto) {
		logger.info("mem:{}",memberDto);
		return memberManagerImpl.save(memberDto);
	}
	
	@PostMapping("/loginAction")
	public int login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
		logger.info("dto = {}",loginDto);
		int result = memberManagerImpl.login(loginDto, request);
		//로그인 실패
		if(result == 0) {
			return 0;
			
		//로그인 성공
		}else {
			request.getSession().setAttribute("user_id", loginDto.getUser_id());
			request.getSession().setAttribute("user_pw", loginDto.getUser_pw());
			return 1;
		}
	}
	
}
