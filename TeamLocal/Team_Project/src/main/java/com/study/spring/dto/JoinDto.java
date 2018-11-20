package com.study.spring.dto;

public class JoinDto {
	int numId;
	String Name;
	String Title;
	String Content;
	String Applicant;
	String Address;
	String Upload;
	String WantedStart;
	String WantedEnd;
	String EventStart;
	String EventEnd;
	String fixed;
	
	public JoinDto() {
		
	}

	public JoinDto(int numId, String name, String title, String content, String applicant, String address,
			String upload, String wantedStart, String wantedEnd, String eventStart, String eventEnd,String fixed) {
		this.numId = numId;
		this.Name = name;
		this.Title = title;
		this.Content = content;
		this.Applicant = applicant;
		this.Address = address;
		this.Upload = upload;
		this.WantedStart = wantedStart;
		this.WantedEnd = wantedEnd;
		this.EventStart = eventStart;
		this.EventEnd = eventEnd;
		this.fixed = fixed;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}

	public String getApplicant() {
		return Applicant;
	}

	public void setApplicant(String Applicant) {
		this.Applicant = Applicant;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getUpload() {
		return Upload;
	}

	public void setUpload(String Upload) {
		this.Upload = Upload;
	}

	public String getWantedStart() {
		return WantedStart;
	}

	public void setWantedStart(String wantedStart) {
		WantedStart = wantedStart;
	}

	public String getWantedEnd() {
		return WantedEnd;
	}

	public void setWantedEnd(String wantedEnd) {
		WantedEnd = wantedEnd;
	}

	public String getEventStart() {
		return EventStart;
	}

	public void setEventStart(String eventStart) {
		EventStart = eventStart;
	}

	public String getEventEnd() {
		return EventEnd;
	}

	public void setEventEnd(String eventEnd) {
		EventEnd = eventEnd;
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	
}
