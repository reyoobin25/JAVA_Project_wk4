package com.example.demo.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.MemberVO;

public interface MemberDao {
	
	//회원가입 부분
	@Insert("INSERT INTO member_tbl(user_id, user_pw, phone, email, register) VALUES(#{user_id}, #{user_pw}, #{phone}, #{email}, #{register})")
	public void save(MemberVO member);
	
	//로그인 부분(user_id찾기)
	@Select("SELECT * FROM member_tbl WHERE user_id = #{user_id}")
	public MemberVO selectMember(@Param("user_id") String user_id);

}

