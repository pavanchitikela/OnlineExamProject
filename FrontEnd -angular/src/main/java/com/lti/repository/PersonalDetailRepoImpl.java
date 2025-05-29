package com.lti.repository;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.PersonalDetail;

@Repository
public class PersonalDetailRepoImpl implements PersonalDetailRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public List<PersonalDetail> getAllPersonalDetails() {
		Query query =	entityManager.createQuery("from PersonalDetail");
		List<PersonalDetail> personalDetail = query.getResultList();
		return personalDetail;
	}
	
	@Transactional
	public void insertPersonalDetail(PersonalDetail personalDetail) {
		entityManager.persist(personalDetail);
	}

	@Transactional
	public PersonalDetail getPersonalDetailEmail(String emailid) {
		PersonalDetail personalDetail = entityManager.find(PersonalDetail.class, emailid);
		return personalDetail;
	}

	@Transactional
	public void updatePersonalDetailMobile(String emailid, String mobile) {
		PersonalDetail personalDetail = entityManager.find(PersonalDetail.class, emailid);
		personalDetail.setMobile(mobile);;		
		entityManager.merge(personalDetail);
	}


	@Transactional
	public void updatePersonalDetailPassword(String emailid, String password) {
		PersonalDetail personalDetail = entityManager.find(PersonalDetail.class, emailid);
		personalDetail.setPassword(password);
		entityManager.merge(personalDetail);
	}


	@Transactional
	public List<PersonalDetail> getPersonalDetailAppID(int applicationid) {		
		
		List<PersonalDetail> personalDetailList = new ArrayList<PersonalDetail>();
		
		Query query = entityManager
				.createQuery("from ApplicationDetail where applicationid =: applicationid")
				.setParameter("applicationid", applicationid);
		personalDetailList = query.getResultList();			
		return personalDetailList;
	}


	@Override
	public PersonalDetail login(String emailid) {
		PersonalDetail personalDetail = entityManager.find(PersonalDetail.class, emailid);
		return personalDetail;
	}


}