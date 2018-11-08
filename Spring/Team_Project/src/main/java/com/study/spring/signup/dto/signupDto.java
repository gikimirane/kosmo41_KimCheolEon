package com.study.spring.signup.dto;

public class signupDto {

	private String EMAIL;
	private String PW;
	private String NAME;
	private String PHONE;
	private String ADMIN;

	public signupDto() {

	}

	public signupDto(String eMAIL, String pW, String nAME, String pHONE, String aDMIN) {
		EMAIL = eMAIL;
		PW = pW;
		NAME = nAME;
		PHONE = pHONE;
		ADMIN = aDMIN;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getADMIN() {
		return ADMIN;
	}

	public void setADMIN(String aDMIN) {
		ADMIN = aDMIN;
	}

}
