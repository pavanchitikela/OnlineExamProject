package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.EmploymentDetail;
import com.lti.entity.LoanDocument;
import com.lti.entity.LoanRequirement;
import com.lti.entity.PropertyDetail;

@Repository
public class HomeLoanRepoImpl implements HomeLoanRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void insertIntoHomeLoan(ApplicationDetail applicationDetail) {

		entityManager.merge(applicationDetail);	
		System.out.println("\n\n\t Data Entered\n\n");
	}

	@Transactional
	public void insertIntoHomeLoanViaAll(ApplicationDetail appDet, EmploymentDetail empDetail, LoanRequirement loanReq,
			PropertyDetail propertyDet, LoanDocument loanDoc)
	{
			ApplicationDetail applicationDetail = appDet;
			
				applicationDetail.setEmploymentDetail(empDetail);
				applicationDetail.setLoanDocument(loanDoc);
				applicationDetail.setLoanRequirement(loanReq);
				applicationDetail.setPropertyDetail(propertyDet);
			
		entityManager.merge(applicationDetail);
	
	}

}
