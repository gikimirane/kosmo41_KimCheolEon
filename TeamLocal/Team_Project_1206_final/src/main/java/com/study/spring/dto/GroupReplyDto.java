package com.study.spring.dto;

public class GroupReplyDto {

	private int numId;
	private String writeName;
	private String content;
	private String timeInfo;
	private String reply;
	
	

	public GroupReplyDto() {
		
	}
	
	public GroupReplyDto(int numId, String writeName, String content, String timeInfo, String reply) {
		this.numId = numId;
		this.writeName = writeName;
		this.content = content;
		this.timeInfo = timeInfo;
		this.reply = reply;
	}


	public int getNumId() {
		return numId;
	}


	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(String timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
