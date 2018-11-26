package com.study.spring.signup.dto;

public class signupDto {

	private String EMAIL;
	private String PW;
	private String NAME;
	private String PHONE;
	private String VERIFY;
	private String ADMIN;
	private String SIGNTIME;
	private String TOKEN;

	public signupDto() {

	}

	public signupDto(String eMAIL, String pW, String nAME, String pHONE, String vERIFY, String aDMIN, String sIGNTIME,
			String tOKEN) {
		EMAIL = eMAIL;
		PW = pW;
		NAME = nAME;
		PHONE = pHONE;
		VERIFY = vERIFY;
		ADMIN = aDMIN;
		SIGNTIME = sIGNTIME;
		TOKEN = tOKEN;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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

	public String getVERIFY() {
		return VERIFY;
	}

	public void setVERIFY(String vERIFY) {
		VERIFY = vERIFY;
	}

	public String getADMIN() {
		return ADMIN;
	}

	public void setADMIN(String aDMIN) {
		ADMIN = aDMIN;
	}

	public String getSIGNTIME() {
		return SIGNTIME;
	}

	public void setSIGNTIME(String sIGNTIME) {
		SIGNTIME = sIGNTIME;
	}

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

}
