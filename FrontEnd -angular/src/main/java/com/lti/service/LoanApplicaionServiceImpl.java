package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.exception.*;
import com.lti.repository.*;

@Service
public class LoanApplicaionServiceImpl implements LoanApplicaionService {

	@Autowired	private HomeLoanRepo homeLoanRepo;
	@Autowired	private PersonalDetailRepo  personalDetRepo;

	
	@Override
	public String addLoanApplication(LoanApplicationDto loanApplicationDto) {
		
		ApplicationDetail appDet 		= new ApplicationDetail();
		EmploymentDetail  empDetail 	= new EmploymentDetail();
		LoanRequirement   loanReq 		= new LoanRequirement();
		PropertyDetail    propertyDet 	= new PropertyDetail();
		LoanDocument      loanDoc 		= new LoanDocument();
		TrackingDetail    trackDet 		= new TrackingDetail();
		
		try {
			PersonalDetail personalDetail = personalDetRepo.getPersonalDetailEmail(loanApplicationDto.getEmailid());

			if (personalDetail==null) {
				throw new HomeLoanException("Invalid Email");
			}else {
				empDetail.setApplicationDetail(appDet);
				empDetail.setPersonalDetail(personalDetail);
					empDetail.setApplicationid(appDet.getApplicationid());
					empDetail.setEmploymentType(loanApplicationDto.getEmploymentType());
					empDetail.setMonthlyIncome(loanApplicationDto.getMonthlyIncome());
					empDetail.setOrganisationName(loanApplicationDto.getOrganisationName());
					empDetail.setOrganisationType(loanApplicationDto.getOrganisationType());
					empDetail.setRetirementAge(loanApplicationDto.getRetirementAge());
				
				loanDoc.setApplicationDetail(appDet);
					loanDoc.setApplicationid(appDet.getApplicationid());
					loanDoc.setLoa(loanApplicationDto.getLoa());
					loanDoc.setAadhar(loanApplicationDto.getAadhar());
					loanDoc.setAgrmntToSale(loanApplicationDto.getAgrmntToSale());
					loanDoc.setVoterid(loanApplicationDto.getVoterid());
					loanDoc.setPan(loanApplicationDto.getPan());
					loanDoc.setNocFromBuilder(loanApplicationDto.getNocFromBuilder());
				
				propertyDet.setApplicationDetail(appDet);
					propertyDet.setApplicationid(appDet.getApplicationid());
					propertyDet.setPropertyCost(loanApplicationDto.getPropertyCost());
					propertyDet.setPropertyLocation(loanApplicationDto.getPropertyLocation());
					propertyDet.setPropertyName(loanApplicationDto.getPropertyName());
				
				loanReq.setApplicationDetail(appDet);
					loanReq.setApplicationid(appDet.getApplicationid());
					loanReq.setRequiredAmount(loanApplicationDto.getRequiredAmount());
					loanReq.setEligibleAmount((float) (empDetail.getMonthlyIncome()*60*0.6));
				
				trackDet.setApplicationDetail(appDet);
					trackDet.setApplicationid(appDet.getApplicationid());
					appDet.setTrackingDetail(trackDet);
					
				appDet.setPersonalDetail(personalDetail);
				
				homeLoanRepo.insertIntoHomeLoanViaAll(appDet, empDetail, loanReq, propertyDet, loanDoc);
			}	
			return "Application Sucessful";
		} catch (HomeLoanException e) {
			throw e;
		}
	}

}
