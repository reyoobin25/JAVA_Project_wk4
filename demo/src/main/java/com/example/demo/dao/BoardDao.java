package com.example.demo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardReadDto;
import com.example.demo.vo.BoardVO;

public interface BoardDao {
	//총 게시물 리스트
	public List<BoardDto> selectBoardList();
	
	//총 게시물 수
	public int selectBoardCnt();
	
	//게시글 작성
	@Insert("INSERT INTO board_tbl(member_user_id, title, content, write_date, view) VALUES(#{member_user_id}, #{title}, #{content}, now(), #{view})")
	public int save(BoardVO boardVO);

	//게시글 읽기
	@Select("SELECT no,member_user_id, title, content, write_date,view FROM board_tbl WHERE no = #{no}")
	public BoardReadDto selectBoardRead(@Param("no") int no, HttpServletRequest request);
	
	@Update("UPDATE board_tbl SET title=#{title}, content=#{content} WHERE no = #{no}")
	public int update(BoardVO boardVO, @Param("no") int no, HttpServletRequest request);
	
	@Delete("DELETE FROM board_tbl WHERE no = #{no} AND member_user_id = #{member_user_id}")
	public int delete(@Param("no") int no, @Param("member_user_id") String memeber_user_id);
	
	@Update("UPDATE board_tbl SET view = view+1 WHERE no = #{no} ")
	public void viewAdd(@Param("no") int no);
	
	@Select("SELECT no, title, member_user_id, write_date, view FROM board_tbl ORDER BY no DESC limit #{startBoard}, 10 ")
	public List<BoardDto> selectBoardPage(@Param("startBoard") int startBoard);
	
}
