package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.LoanDocument;


@Repository
public class LoanDocumentRepoImpl implements LoanDocumentRepo{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<LoanDocument> getAllLoanDocument() {
		Query query = entityManager.createQuery("from LoanDocument");
		List<LoanDocument> loanDocumentList = query.getResultList();
		return loanDocumentList;
	}

	@Override
	public LoanDocument getLoanDocumentByApplicationId(int applicationId) {
		LoanDocument loanDocument = entityManager.find(LoanDocument.class, applicationId);
		return loanDocument;
	}

	@Transactional
	public void insertLoanDocument(LoanDocument loanDocument) { 
		
		int appID = loanDocument.getApplicationid();
		ApplicationDetail applicationDetail=entityManager.find(ApplicationDetail.class, appID);
		LoanDocument loanDocument2 = loanDocument;
		loanDocument2.setApplicationDetail(applicationDetail);
		
		entityManager.persist(loanDocument);
		
	}
	
}