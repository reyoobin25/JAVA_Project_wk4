package com.example.demo.dto;

public class CommentWriteDto {
	private int comment_board_no;
	private String comment_user_id;
	private String comment_write_date;
	private String content;
	
	public CommentWriteDto(int comment_board_no, String comment_user_id, String comment_write_date, String content) {
		super();
		this.comment_board_no = comment_board_no;
		this.comment_user_id = comment_user_id;
		this.comment_write_date = comment_write_date;
		this.content = content;
	}
	
	public int getComment_board_no() {
		return comment_board_no;
	}
	public void setComment_board_no(int comment_board_no) {
		this.comment_board_no = comment_board_no;
	}
	public String getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(String comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public String getComment_write_date() {
		return comment_write_date;
	}
	public void setComment_write_date(String comment_write_date) {
		this.comment_write_date = comment_write_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
