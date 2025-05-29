package com.lti.dto;

import java.time.LocalDate;

public class StatusDto {
	
	String emailid;
	int applicationid;
	String status;
	LocalDate applicationDate;
	String fname;
	String lname;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	public int getapplicationid() {
		return applicationid;
	}
	public void setapplicationid(int applicationid) {
		this.applicationid = applicationid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "StatusDto [emailid=" + emailid + ", applicationid=" + applicationid + ", status=" + status
				+ ", applicationDate=" + applicationDate + "]";
	}


	
}
