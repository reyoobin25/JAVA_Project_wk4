package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardReadDto;
import com.example.demo.dto.BoardWriteDto;
import com.example.demo.service.BoardManagerImpl;
import com.example.demo.vo.BoardVO;

@RestController
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	BoardManagerImpl boardManagerImpl;

	@RequestMapping("/boardDeleteAction/{no}")
	public int delete(@PathVariable("no") int no, HttpServletRequest request) {
		return boardManagerImpl.delete(no, request);
	}

	@GetMapping(value="/selectBoardCnt")
	public int selectBoardCnt() {
		return boardManagerImpl.selectBoardCnt();
	}

	@GetMapping(value = "/boardList/{page}")
	public List<BoardDto> boardlist(@PathVariable("page") int page) {

		List<BoardDto> boardlist = boardManagerImpl.selectBoardPage(page);

		logger.info(boardlist.toString());

		return boardlist;
	}

	@GetMapping(value = "/boardReadAction/{no}")
	public BoardReadDto boardReadAction(@PathVariable(value = "no") int no, HttpServletRequest request) {
		boardManagerImpl.boardViewAdd(no);
		return boardManagerImpl.selectBoardRead(no, request);
	}

	@RequestMapping("/boardUpdateAction/{no}")
	public int boardUpate(BoardVO boardVo, @PathVariable("no") int no, HttpServletRequest request) {
		return boardManagerImpl.update(boardVo, no, request);
	}

	@PostMapping(value = "/boardWriteAction")
	public int boardWriteAction(@RequestBody BoardWriteDto boardWriteDto, HttpServletRequest request) {
		try {
			boardManagerImpl.save(boardWriteDto, request);
			return 1;
		} catch (Exception e) {
			logger.error("boardWrite쪽 Error{}:", e);
			return 0;
		}
	}
}
