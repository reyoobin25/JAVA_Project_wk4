package com.example.demo.dto;

import java.sql.Date;

public class BoardReadDto {
	private long no;
	private String member_user_id;
	private String title;
	private String content;
	private Date write_date;
	private int view;

	public BoardReadDto(long no, String member_user_id, String title, String content, Date write_date, int view) {
		super();
		this.no = no;
		this.member_user_id = member_user_id;
		this.title = title;
		this.content = content;
		this.write_date = write_date;
		this.view = view;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getMember_user_id() {
		return member_user_id;
	}
	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	@Override
	public String toString() {
		return "BoardReadDto [no=" + no + ", member_user_id=" + member_user_id + ", title=" + title + ", content="
				+ content + ", write_date=" + write_date + ", view=" + view + "]";
	}
	
}
