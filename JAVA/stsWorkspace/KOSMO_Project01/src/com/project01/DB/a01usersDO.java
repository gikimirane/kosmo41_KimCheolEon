package com.project01.DB;

public class a01usersDO {
	
	private String NAME;
	private String BLOCK;
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		System.out.println("setDO:"+nAME);
		NAME = nAME;
	}
	public String getBLOCK() {
		return BLOCK;
	}
	public void setBLOCK(String bLOCK) {
		System.out.println("setDO:"+bLOCK);
		BLOCK = bLOCK;
	}
}
