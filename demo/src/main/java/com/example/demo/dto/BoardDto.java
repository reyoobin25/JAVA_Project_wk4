package com.example.demo.dto;

public class BoardDto {
	private long no;
	private String title;
	private String member_user_id;
	private String write_date;
	private int view;
	
	
	public BoardDto(long no, String title, String member_user_id, String write_date, int view) {
		super();
		this.no = no;
		this.title = title;
		this.member_user_id = member_user_id;
		this.write_date = write_date;
		this.view = view;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMember_user_id() {
		return member_user_id;
	}
	public void setMember_user_id(String member_user_id) {
		this.member_user_id = member_user_id;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
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
		return "BoardDto [no=" + no + ", title=" + title + ", member_user_id=" + member_user_id + ", write_date="
				+ write_date + ", view=" + view + "]";
	}
	
}
