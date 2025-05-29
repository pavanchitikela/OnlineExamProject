package com.lti.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.lti.entity.LoanDocument;


@Repository
public interface LoanDocumentRepo {
	
	public List<LoanDocument> getAllLoanDocument();
	public LoanDocument getLoanDocumentByApplicationId(int applicationId);
	public void insertLoanDocument (LoanDocument loanDocument);
}
