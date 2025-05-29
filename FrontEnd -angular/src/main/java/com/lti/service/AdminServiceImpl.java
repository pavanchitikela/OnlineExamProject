package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.exception.HomeLoanException;
import com.lti.repository.AdminLoginRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired private AdminLoginRepo adminLoginRepo;
	
	@Override
	public String adminLogin(String Id, String password) {

		try {
			com.lti.entity.AdminLogin adminLogin = adminLoginRepo.loginAdmin(Id);

			if (adminLogin==null) {
				throw new HomeLoanException("Invalid Admin User");

			} else if(!adminLogin.getPassword().equals(password)) {		
				throw new HomeLoanException("Wrong Password");
				
				}else {
					return "Login Sucessful";
				}
		}
		catch (HomeLoanException e) {
			throw e;
		}
	}

}
