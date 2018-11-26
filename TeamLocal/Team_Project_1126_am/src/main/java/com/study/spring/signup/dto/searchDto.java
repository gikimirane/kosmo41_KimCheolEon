package com.study.spring.signup.dto;

public class searchDto {

	private String STARTTIME;
	private String ENDTIME;
	private String MOVETIME;
	private String UPLOAD;

	public searchDto() {

	}

	public searchDto(String sTARTTIME, String eNDTIME, String mOVETIME, String uPLOAD) {
		super();
		STARTTIME = sTARTTIME;
		ENDTIME = eNDTIME;
		MOVETIME = mOVETIME;
		UPLOAD = uPLOAD;
	}

	public String getSTARTTIME() {
		return STARTTIME;
	}

	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}

	public String getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}

	public String getMOVETIME() {
		return MOVETIME;
	}

	public void setMOVETIME(String mOVETIME) {
		MOVETIME = mOVETIME;
	}

	public String getUPLOAD() {
		return UPLOAD;
	}

	public void setUPLOAD(String uPLOAD) {
		UPLOAD = uPLOAD;
	}
}
