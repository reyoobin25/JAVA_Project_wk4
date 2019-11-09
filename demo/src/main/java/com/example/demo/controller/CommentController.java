package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentWriteDto;
import com.example.demo.service.CommentManagerImpl;

@RestController
public class CommentController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CommentManagerImpl commentManagerImpl;
	
	@RequestMapping("/commentListAll/{no}")
	public List<CommentDto> commentList(@PathVariable("no") int no) {
		return commentManagerImpl.commentList(no);
	}
	
	@RequestMapping(value = "/commentWriteAction")
	public int commentWrite(CommentWriteDto commentWriteDto) {
		
		logger.info("--------------------------------------");
		logger.info("1: " + commentWriteDto.getComment_board_no());
		logger.info("2: " + commentWriteDto.getComment_user_id());
		logger.info("4: " + commentWriteDto.getContent());
		logger.info("--------------------------------------");
		commentManagerImpl.commentWrite(commentWriteDto);
		return 1;
	}
	
	@RequestMapping("/commentDeleteAction/{no}")
	public int commentDelete(@PathVariable("no") int no, HttpServletRequest request) {
		commentManagerImpl.commentDelete(no, request);
		return 1;
	}
	
}
