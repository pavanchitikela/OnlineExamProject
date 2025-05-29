package com.lti.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.exception.*;
import com.lti.repository.*;

@Service
public class ApplicationDetailServiceImpl implements ApplicationDetailService {

	@Autowired
	ApplicationDetailRepo applicationDetailRepo;
	@Autowired
	TrackingDetailRepo trackingDetailRepo;

	@Override
	public void insertApplicationDetail(String emailid) {
		try {
			applicationDetailRepo.insertApplicationDetail(emailid);
		}catch (Exception e) {
			throw new RuntimeException("Problem Creating ApplicationDetail");
		}
		
	}

	@Override
	public List<StatusDto> getAllApplicationDetail(String emailid) {
		try {
			List<ApplicationDetail> applicationDetail = applicationDetailRepo.getApplicationDetailByEmail(emailid);
			
			if(applicationDetail==null) {
				throw new HomeLoanException("unable to fetch data");
			}else {
				List<StatusDto> statusDtoList = new ArrayList<StatusDto>();
				
				for (ApplicationDetail applicationDetail2 : applicationDetail) {
					System.out.println("\t\t"+applicationDetail2);
					TrackingDetail trackingDetail = trackingDetailRepo.getTrackingDetailByAppId(applicationDetail2.getApplicationid());
					System.out.println("\t"+trackingDetail);
					if(trackingDetail==null) {
						continue;
					}else {
						StatusDto statusDto = new StatusDto();
						statusDto.setEmailid(emailid);
						statusDto.setapplicationid(applicationDetail2.getApplicationid());
						statusDto.setStatus(trackingDetail.getStatus());
						statusDto.setApplicationDate(trackingDetail.getApplicationDate());
						statusDtoList.add(statusDto);
						System.out.println("\t"+applicationDetail2.getTrackingDetail().getStatus());
					}
				}
				return statusDtoList;
			}
		} catch (HomeLoanException e) {
			throw e;
		}
	}
	
	
}
