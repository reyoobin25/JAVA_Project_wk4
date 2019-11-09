package com.example.demo.dto;

public class BoardWriteDto {
	private String title;
	private String content;
	
	public BoardWriteDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		return "BoardWriteDto [title=" + title + ", content=" + content + "]";
	}
	
}
