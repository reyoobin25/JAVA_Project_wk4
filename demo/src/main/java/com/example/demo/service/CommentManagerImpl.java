package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentDao;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentWriteDto;


@Service
public class CommentManagerImpl {
	
	@Autowired
	private CommentDao commentDao;
	
	public List<CommentDto> commentList(int no) {
		return commentDao.commentList(no);
	}
	
	public int commentWrite(CommentWriteDto commentWriteDto) {
		return commentDao.commentWrite(commentWriteDto);
	}
	
	public void commentDelete(int no, HttpServletRequest request) {
		String user_id = (String)request.getSession().getAttribute("user_id");
		commentDao.commentDelete(no, user_id);
	}
}
