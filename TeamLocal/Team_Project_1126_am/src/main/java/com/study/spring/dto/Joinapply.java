package com.study.spring.dto;

public class Joinapply {
	String timeinfo;
	int numId_FK;
	String userName;
	String state;
	String MG_EMAIL;

	public Joinapply() {

	}

	public Joinapply(String timeinfo, int numId_FK, String userName, String state, String mG_EMAIL) {
		this.timeinfo = timeinfo;
		this.numId_FK = numId_FK;
		this.userName = userName;
		this.state = state;
		MG_EMAIL = mG_EMAIL;
	}

	public String getTimeinfo() {
		return timeinfo;
	}

	public void setTimeinfo(String timeinfo) {
		this.timeinfo = timeinfo;
	}

	public int getNumId_FK() {
		return numId_FK;
	}

	public void setNumId_FK(int numId_FK) {
		this.numId_FK = numId_FK;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMG_EMAIL() {
		return MG_EMAIL;
	}

	public void setMG_EMAIL(String mG_EMAIL) {
		MG_EMAIL = mG_EMAIL;
	}

}
