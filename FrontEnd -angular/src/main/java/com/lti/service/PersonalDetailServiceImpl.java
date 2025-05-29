package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.exception.*;
import com.lti.repository.*;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService {

	@Autowired
	PersonalDetailRepo personalDetailRepo;
	
	@Override
	public String userRegisterService(PersonalDetail personalDetail) {
			try {
				personalDetailRepo.insertPersonalDetail(personalDetail);
				return "Personal Details added";
			} catch (Exception e) {
				throw new HomeLoanException(e.getMessage());
			}
	}
	
	@Override
	public PersonalDetail getPersonalDetailByEmailService(String emailid) {
		try {
			PersonalDetail personalDetail = personalDetailRepo.getPersonalDetailEmail(emailid);
			
			if (personalDetail == null) {
				throw new HomeLoanException("Wrong Email Id");
			}
			RegisterDto registerDto = new RegisterDto();
			registerDto.setEmailid(personalDetail.getEmailid());
			registerDto.setDob(personalDetail.getDob());
			registerDto.setFname(personalDetail.getFname());
			return personalDetail;	
			
		} catch (HomeLoanException e) {
			throw new HomeLoanException("Email Not Found");
		}
	}
	
	@Override
	public LoginDto userloginService(String emailId,String userPassword) {
		LoginDto loginDto = new LoginDto();
		try {
		PersonalDetail personalDetail= personalDetailRepo.login(emailId);
		if(personalDetail==null) {
			throw new HomeLoanException("invalid Email-id");
			}else if(!personalDetail.getPassword().equals(userPassword)) {
				throw new HomeLoanException("Invalid Password");
				}else {
					
					loginDto.setFname(personalDetail.getFname());
					loginDto.setMname(personalDetail.getMname());
					loginDto.setLname(personalDetail.getLname());
					
					return loginDto;
				}
		} catch (HomeLoanException e) {
			throw e;
		}
	}

	@Override
	public String updatePasswordService(String emailid, String oldPassword, String newPassword) {
			try {
				PersonalDetail personalDetail = personalDetailRepo.getPersonalDetailEmail(emailid);
				System.out.println("Serv Impl\tpersonalDetail :"+personalDetail);
				if(personalDetail==null) {
				System.out.println("\tIf");
				throw new HomeLoanException("invalid Email");
					}else if(!personalDetail.getPassword().equals(oldPassword)) {
						System.out.println("\tElse If ");
						throw new HomeLoanException("PassWord Mismatch");//personalDetailRepo.updatePersonalDetailPassword(emailid, newPassword);
						}else {
							System.out.println("\tElse");
							personalDetailRepo.updatePersonalDetailPassword(emailid, newPassword);
							throw new HomeLoanException("Password change Sucessful");
					}
			} catch (Exception e) {
				throw new HomeLoanException("Error Updating Password");
			}
	}

	@Override
	public String changePasswordService(String emailid, String password) {
		try {
			PersonalDetail personalDetail = personalDetailRepo.getPersonalDetailEmail(emailid);
			System.out.println("Serv Impl\tpersonalDetail :"+personalDetail);
			if(personalDetail==null) {
			throw new HomeLoanException("invalid Email");
					}else {
						personalDetailRepo.updatePersonalDetailPassword(emailid, password);
						throw new HomeLoanException("Password change Sucessful");
				}
		} catch (Exception e) {
			throw new HomeLoanException("Error Updating Password");
		}
	}	
}
