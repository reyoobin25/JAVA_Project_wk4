package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.vo.MemberVO;

@Service
public class MemberManagerImpl {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MemberDao memberDao;

	public int save(MemberDto memberDto) {
		MemberVO memberVO = new MemberVO(memberDto.getUserId(), memberDto.getUserPw(), memberDto.getPhone(),memberDto.getEmail());
		try {
			memberDao.save(memberVO);
			return 1;
		} catch (Exception e) {
			logger.error("save error:{}", e);
			return 0;
		}
	}

	public int login(LoginDto loginDto, HttpServletRequest request) {
		MemberVO memberVO;
		
		try {
			memberVO = memberDao.selectMember(loginDto.getUser_id());
		} catch (Exception e) {
//			logger.error("login error:{}", e);
			e.printStackTrace();
			return 0;
		}
		if (memberVO == null || memberVO.getUser_id() == null) {
			return 0;
		}
		if (!memberVO.getUser_pw().equals(loginDto.getUser_pw())) {
			return 0;
		} else {
			request.getSession().setAttribute("user_id", loginDto.getUser_id());
			request.getSession().setAttribute("user_pw", loginDto.getUser_pw());
			return 1;
		}
	}
}
