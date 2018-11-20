package com.study.spring.signup.dto;

public class RecordDto {

	private int num;
	private String eMail;
	private String startTime;
	private String endTime;
	private String moveTime;
	private String upLoad;
	private String map;
	
	public RecordDto() {
		
	}

	public RecordDto(int num,String eMail, String startTime, String endTime, String moveTime, String upLoad,String map) {
		this.num = num;
		this.eMail = eMail;
		this.startTime = startTime;
		this.endTime = endTime;
		this.moveTime = moveTime;
		this.upLoad = upLoad;
		this.map = map;
	}

	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getMoveTime() {
		return moveTime;
	}


	public void setMoveTime(String moveTime) {
		this.moveTime = moveTime;
	}


	public String getUpLoad() {
		return upLoad;
	}


	public void setUpLoad(String upLoad) {
		this.upLoad = upLoad;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}	
	
}
