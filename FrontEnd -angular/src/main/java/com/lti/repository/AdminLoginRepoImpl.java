package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.lti.entity.AdminLogin;

@Repository
public class AdminLoginRepoImpl implements AdminLoginRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public AdminLogin loginAdmin(String adminId) {
		AdminLogin adminLogin = entityManager.find(AdminLogin.class, adminId);
		return adminLogin;
		
	}

}
