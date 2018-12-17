package com.study.spring.dto;

public class GroupRunningDto {

	private int num;
	private String eMail;
	private String startTime;
	private String endTime;
	private String moveTime;
	private String upLoad;
	private String map1;
	private String map2;
	private String map3;
	private String map4;
	private String map5;

	public GroupRunningDto() {

	}

	public GroupRunningDto(int num, String eMail, String startTime, String endTime, String moveTime, String upLoad,
			String map1, String map2, String map3, String map4, String map5) {
		this.num = num;
		this.eMail = eMail;
		this.startTime = startTime;
		this.endTime = endTime;
		this.moveTime = moveTime;
		this.upLoad = upLoad;
		this.map1 = map1;
		this.map2 = map2;
		this.map3 = map3;
		this.map4 = map4;
		this.map5 = map5;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getMap1() {
		return map1;
	}

	public void setMap1(String map1) {
		this.map1 = map1;
	}

	public String getMap2() {
		return map2;
	}

	public void setMap2(String map2) {
		this.map2 = map2;
	}

	public String getMap3() {
		return map3;
	}

	public void setMap3(String map3) {
		this.map3 = map3;
	}

	public String getMap4() {
		return map4;
	}

	public void setMap4(String map4) {
		this.map4 = map4;
	}

	public String getMap5() {
		return map5;
	}

	public void setMap5(String map5) {
		this.map5 = map5;
	}
	
}
