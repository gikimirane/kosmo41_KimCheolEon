package com.study.spring.signup.dto;

public class signupDto {

	private String ID;
	private String PW;
	private String NAME;
	private String PHONE;
	private String EMAIL;
	private String CONFIRM;
	private String ADMIN;
	
	public signupDto() {
		
	}

	public signupDto(String iD, String pW, String nAME, String pHONE, String eMAIL, String cONFIRM, String aDMIN) {
		ID = iD;
		PW = pW;
		NAME = nAME;
		PHONE = pHONE;
		EMAIL = eMAIL;
		CONFIRM = cONFIRM;
		ADMIN = aDMIN;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getCONFIRM() {
		return CONFIRM;
	}

	public void setCONFIRM(String cONFIRM) {
		CONFIRM = cONFIRM;
	}

	public String getADMIN() {
		return ADMIN;
	}

	public void setADMIN(String aDMIN) {
		ADMIN = aDMIN;
	}

}
