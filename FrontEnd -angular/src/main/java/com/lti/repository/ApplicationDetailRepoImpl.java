package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.PersonalDetail;

@Repository
public class ApplicationDetailRepoImpl implements ApplicationDetailRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<ApplicationDetail> getAllApplicationDetail() {
		Query query = entityManager.createQuery(" from ApplicationDetail");
		List<ApplicationDetail> appDetail = query.getResultList();
		return appDetail;
	}

	@Override
	public List<ApplicationDetail> getApplicationDetailByEmail(String emailId) {
		Query query = entityManager
					.createQuery("from ApplicationDetail where emailId=:emailId")
						.setParameter("emailId", emailId);
		List<ApplicationDetail> applicationDetail;
		applicationDetail = query.getResultList();
		return applicationDetail;
	}

	@Transactional
	public void insertApplicationDetail(String emailId) {
		
		PersonalDetail personalDetail = entityManager.find(PersonalDetail.class, emailId);
		
		ApplicationDetail applicationDetail = new ApplicationDetail(/*appId, personalDetail*/);
		applicationDetail.setPersonalDetail(personalDetail);
		
		entityManager.merge(applicationDetail);
	} 

	@Override
	public ApplicationDetail getApplicationDetailByAppId(int appid) {
		ApplicationDetail appDetail = entityManager.find(ApplicationDetail.class, appid);
		return appDetail;
	}

	@Override
	public int totalApplicationDetail() {
		Query query = entityManager.createQuery("from ApplicationDetail");
		List<ApplicationDetail> applicationDetail = query.getResultList();
		
		int total = 0;
		for (ApplicationDetail application : applicationDetail) {
			total+=1;
		}
		return total;
	}

}
