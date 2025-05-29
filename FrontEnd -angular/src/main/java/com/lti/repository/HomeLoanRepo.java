package com.lti.repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.EmploymentDetail;
import com.lti.entity.LoanDocument;
import com.lti.entity.LoanRequirement;
import com.lti.entity.PropertyDetail;

public interface HomeLoanRepo {
	
	public void	insertIntoHomeLoanViaAll(ApplicationDetail appDet,
										 EmploymentDetail empDetail, 
										 LoanRequirement loanReq,
										 PropertyDetail propertyDet,
										 LoanDocument loanDoc
										);
	}
