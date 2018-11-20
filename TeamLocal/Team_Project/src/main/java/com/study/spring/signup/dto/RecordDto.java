package com.study.spring.signup.dto;

public class RecordDto {

	private int num;
	private String eMali;
	private String startTime;
	private String endTime;
	private String moveTime;
	private String upLoad;
	
	public RecordDto() {
		
	}

	public RecordDto(int num,String eMali, String startTime, String endTime, String moveTime, String upLoad) {
		this.num = num;
		this.eMali = eMali;
		this.startTime = startTime;
		this.endTime = endTime;
		this.moveTime = moveTime;
		this.upLoad = upLoad;
	}

	public String geteMali() {
		return eMali;
	}


	public void seteMali(String eMali) {
		this.eMali = eMali;
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

}
