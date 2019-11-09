package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

//import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentWriteDto;

public interface CommentDao {

	public List<CommentDto> commentList(@Param("no") int no);
	
	public int commentWrite(CommentWriteDto commentWriteDto);
	
	public int commentDelete(int no, String comment_user_id);
}
