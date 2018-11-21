package com.study.spring.signup.dto;

public class content_ReplyDto {

	private int numId;
	private String name;
	private String date;
	
	
	public content_ReplyDto() {
		
	}
	
	public content_ReplyDto(int numId, String name, String date) {
		this.numId = numId;
		this.name = name;
		this.date = date;
	}

	public int getNumId() {
		return numId;
	}


	public void setNumId(int numId) {
		this.numId = numId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

}
