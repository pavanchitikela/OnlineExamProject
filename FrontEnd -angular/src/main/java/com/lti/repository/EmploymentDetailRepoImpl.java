package com.lti.repository;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.EmploymentDetail;
import com.lti.entity.PersonalDetail;

@Repository
public class EmploymentDetailRepoImpl implements EmploymentDetailRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional	
	public void insertEmploymentDetail(EmploymentDetail employmentDetail) {
		int appID = employmentDetail.getApplicationid();
		ApplicationDetail applicationDetail=entityManager.find(ApplicationDetail.class, appID);
		applicationDetail.getPersonalDetail().getEmailid();
		EmploymentDetail employmentDetail2 = employmentDetail;
		employmentDetail2.setPersonalDetail(applicationDetail.getPersonalDetail());
	
		entityManager.persist(employmentDetail2);
	}

		
	@Transactional
	public List<EmploymentDetail> getAllEmploymentDetails() {
				
		Query query =	entityManager.createQuery("from EmploymentDetail");
		List<EmploymentDetail> employmentDetail = query.getResultList();
		return employmentDetail;
	
	}

	
	@Transactional
	public List<EmploymentDetail> getEmploymentDetailEmail(String emailid) {
		
		Query query = entityManager.createQuery("from EmploymentDetail where emailid=:emailid")
								   .setParameter("emailid", emailid);
		List<EmploymentDetail> employmentDetail = query.getResultList();
		return employmentDetail;
		
	}

	
	@Transactional
	public EmploymentDetail getEmploymentDetailAppID(int applicationid) {
				
		EmploymentDetail employmentDetail = entityManager.find(EmploymentDetail.class, applicationid);
		return employmentDetail;
		
	}

}
