package com.example.demo.dto;

public class CommentDto {
	private int no;
	private String comment_user_id;
	private String comment_write_date;
	private String content;
	
	public CommentDto(int no, String comment_user_id, String comment_write_date, String content) {
		super();
		this.no = no;
		this.comment_user_id = comment_user_id;
		this.comment_write_date = comment_write_date;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "CommentDto [no=" + no + ", comment_user_id=" + comment_user_id + ", comment_write_date="
				+ comment_write_date + ", content=" + content + "]";
	}
	
}
