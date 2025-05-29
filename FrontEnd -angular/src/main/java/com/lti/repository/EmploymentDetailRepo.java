package com.lti.repository;

import java.util.List;  

import com.lti.entity.EmploymentDetail;

public interface EmploymentDetailRepo { //4methods and test cases
	
	public void insertEmploymentDetail(EmploymentDetail employmentDetail); //Create	7
	public List<EmploymentDetail> getAllEmploymentDetails();	//8
	public List<EmploymentDetail> getEmploymentDetailEmail(String emailid); //Read	9
	public EmploymentDetail getEmploymentDetailAppID(int applicationid);	//10
	
}
