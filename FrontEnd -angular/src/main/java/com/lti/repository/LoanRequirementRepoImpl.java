package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.LoanRequirement;

@Repository
public class LoanRequirementRepoImpl implements LoanRequirementRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<LoanRequirement> getAllLoanRequirement() {			//done

		Query query = entityManager.createQuery("from LoanRequirement ");
		List<LoanRequirement> loanRequirement = query.getResultList();		
		return loanRequirement;
	}

	@Transactional
	public void addLoanRequirement(LoanRequirement loanReq, int appId) {	//done
		
		ApplicationDetail applicationDetail = entityManager.find(ApplicationDetail.class, appId);
		
		LoanRequirement loanRequirement = loanReq;
		loanRequirement.setApplicationDetail(applicationDetail);
		applicationDetail.setLoanRequirement(loanRequirement);

		entityManager.persist(loanRequirement);
	}

	@Override
	public LoanRequirement getLoanRequirement(int applicationId) {		//done
		LoanRequirement loanRequirement = entityManager.find(LoanRequirement.class, applicationId);
		return loanRequirement;
	}
}
