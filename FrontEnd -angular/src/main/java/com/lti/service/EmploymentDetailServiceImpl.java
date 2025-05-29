package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.repository.*;

@Service
public class EmploymentDetailServiceImpl implements EmploymentDetailService {

	@Autowired
	EmploymentDetailRepo employmentDetailRepo;

	@Override
	public String insertEmploymentDetailService(EmploymentDto empDto) {
		
		ApplicationDetail applicationDetail = new ApplicationDetail();
		applicationDetail.getApplicationid();
		
		EmploymentDto employmentDto = empDto;
		
		EmploymentDetail employmentDetail = new EmploymentDetail();

		employmentDto.setApplicationid(applicationDetail.getApplicationid());
		employmentDto.setEmploymentType(employmentDetail.getEmploymentType());
		employmentDto.setMonthlyIncome(employmentDetail.getMonthlyIncome());
		employmentDto.setOrganisationName(employmentDetail.getOrganisationName());
		employmentDto.setOrganisationType(employmentDetail.getOrganisationType());
		employmentDto.setRetirementAge(employmentDetail.getRetirementAge());
		
		employmentDetailRepo.insertEmploymentDetail(employmentDetail);
		return "Employee Details Successfull";
	}
	

}
