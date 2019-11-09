package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BoardReadDto;
import com.example.demo.service.BoardManagerImpl;

@Controller
public class BoardPageController {

	@Autowired
	BoardManagerImpl boardManagerImpl;
	
	
	@GetMapping(value = "/index.html")
	public String index() {
		return "index";
	}
	
	//글 쓰기
	@GetMapping(value = "/boardWriteForm.html")
	public String boardWrite() {
		return "boardWriteForm";
	}
	
	//글 보기
	@RequestMapping(value = "/boardReadForm/{no}")
	public String boardRead(@PathVariable(value = "no") int no, HttpServletRequest request) {
			return "boardReadForm";
	}
	
	//글 수정
	@RequestMapping(value = "/boardUpdateForm/{no}")
	public String boardUpdate(@PathVariable(value = "no") int no, HttpServletRequest request, ModelMap modelMap) {
		BoardReadDto board = boardManagerImpl.selectBoardRead(no, request);
		modelMap.addAttribute("title", board.getTitle());
		modelMap.addAttribute("member_user_id", board.getMember_user_id());
		modelMap.addAttribute("content", board.getContent());
		modelMap.addAttribute("no", no);
		return "boardUpdateForm";
	}
}
