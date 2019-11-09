package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardReadDto;
import com.example.demo.dto.BoardWriteDto;
import com.example.demo.vo.BoardVO;

@Service
public class BoardManagerImpl {

	@Autowired
	private BoardDao boardDao;

	// 총 게시물 수
	public int selectBoardCnt() {
		return boardDao.selectBoardCnt();
	}
	
	public List<BoardDto> selectBoardPage(int page){
		return boardDao.selectBoardPage((page*10));
	}

	// 총 게시글 출력
	public List<BoardDto> selectBoardList() {
		return boardDao.selectBoardList();
	}

	// 게시글 작성
	public int save(BoardWriteDto board, HttpServletRequest request) {
		String user_id = (String) request.getSession().getAttribute("user_id");
		BoardVO boardVO = new BoardVO(user_id, board.getTitle(), board.getContent(), 0);
		try {
			boardDao.save(boardVO);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// 게시글 보기
	public BoardReadDto selectBoardRead(int no, HttpServletRequest request) {
		String user_id = (String) request.getSession().getAttribute("user_id");
		return boardDao.selectBoardRead(no, request);
	}
	
	//댓글
	public void boardViewAdd(int no) {
		boardDao.viewAdd(no);
	}
	
	//글 수정
	public int update(BoardVO boardVO, int no, HttpServletRequest request) {
		return boardDao.update(boardVO, no, request);
	}
	
	//글 삭제
	public int delete(int no, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String memebr_user_id = (String) session.getAttribute("user_id");
		return boardDao.delete(no, memebr_user_id);
	}
}
