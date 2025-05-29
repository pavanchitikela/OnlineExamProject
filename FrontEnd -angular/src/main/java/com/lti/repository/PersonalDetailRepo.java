package com.lti.repository;

import java.util.List; 

import com.lti.entity.PersonalDetail;

public interface PersonalDetailRepo {
	
	void insertPersonalDetail(PersonalDetail personalDetail); 
	public List<PersonalDetail> getAllPersonalDetails();
	PersonalDetail getPersonalDetailEmail(String emailid);
	List<PersonalDetail> getPersonalDetailAppID(int applicationid);	
	void updatePersonalDetailMobile(String emailid, String mobile); 
	void updatePersonalDetailPassword(String emailid, String password);	
	public PersonalDetail login(String emailId);
		
}


