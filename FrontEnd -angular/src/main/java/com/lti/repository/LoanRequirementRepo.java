package com.lti.repository;

import java.util.List;

import com.lti.entity.LoanRequirement;

public interface LoanRequirementRepo {

	public List<LoanRequirement> getAllLoanRequirement();						//done
	public LoanRequirement getLoanRequirement(int applicationId);				//done
	public void addLoanRequirement(LoanRequirement loanRequirement, int appId);	//done	

}