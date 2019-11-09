package com.example.demo.vo;

public class BoardVO {

	private String member_user_id;
	private String title;
	private String content;
	private String write_date;
	private int view;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(String member_user_id, String title, String content, int view) {
		super();
		this.member_user_id = member_user_id;
		this.title = title;
		this.content = content;
		this.view = view;
	}
	
	public BoardVO(String member_user_id, String title, String content, String write_date, int view) {
		super();
		this.member_user_id = member_user_id;
		this.title = title;
		this.content = content;
		this.write_date = write_date;
		this.view = view;
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
		return "BoardVO [member_user_id=" + member_user_id + ", title=" + title + ", content=" + content
				+ ", write_date=" + write_date + ", view=" + view + "]";
	}
	
}
