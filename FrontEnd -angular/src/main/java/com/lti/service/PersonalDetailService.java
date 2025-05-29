package com.lti.service;

import com.lti.dto.LoginDto;
import com.lti.entity.PersonalDetail;

public interface PersonalDetailService {
	
	public String userRegisterService(PersonalDetail personalDetail);
	public PersonalDetail getPersonalDetailByEmailService(String emailid);
	public LoginDto userloginService(String emailId,String password);
	public String updatePasswordService(String emailid, String oldPassword, String newPassword);
	public String changePasswordService(String emailid, String Password);
	

}
