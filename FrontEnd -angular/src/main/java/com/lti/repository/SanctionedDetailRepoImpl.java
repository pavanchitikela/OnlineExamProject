package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.SanctionedDetail;

@Repository
public class SanctionedDetailRepoImpl implements SanctionedDetailRepo{

	
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public List<SanctionedDetail> getAllSanctionedDetail() {
		
		Query query= entityManager.createNamedQuery("SanctionedDetail.findAll");
		List<SanctionedDetail> sanctionedDetails = query.getResultList();
		
		return sanctionedDetails;
	}

	@Transactional
	public void insertSanctionedDetail(SanctionedDetail sanctionDetail) {
		entityManager.merge(sanctionDetail);
		System.out.println("\tSanctioned Details Entered Successfully");
		
		
	}

	@Override
	public List<SanctionedDetail> getSanctionedDetailByAppId(int appId) {
		Query query = entityManager.createQuery("from SanctionedDetail where applicationId=:applicationId")
									.setParameter("applicationId", appId);
		
		List<SanctionedDetail> sanctionedDetails = query.getResultList();
		return sanctionedDetails;
	}

	@Override
	public SanctionedDetail getSanctionedDetailByAccountNo(int AccountNo) {
		SanctionedDetail sanctionedDetail = entityManager.find(SanctionedDetail.class,AccountNo);
		return sanctionedDetail;
	}

}
		