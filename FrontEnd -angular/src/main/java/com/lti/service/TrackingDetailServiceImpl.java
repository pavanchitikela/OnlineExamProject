package com.lti.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.exception.*;
import com.lti.repository.*;

@Service
public class TrackingDetailServiceImpl implements TrackingDetailService {

	@Autowired
	private TrackingDetailRepo trackingDetailRepo;
	@Autowired
	private ApplicationDetailRepo applicationRepo;

	@Override
	public StatusDto getTrackingDetailByAppId(int applicationId) {
		try {
			StatusDto loanStatusDto = new StatusDto();
			TrackingDetail trackingDetail =  trackingDetailRepo.getTrackingDetailByAppId(applicationId);
			
			loanStatusDto.setApplicationDate(trackingDetail.getApplicationDate());
			loanStatusDto.setapplicationid(trackingDetail.getApplicationid());
			loanStatusDto.setStatus(trackingDetail.getStatus());
			
			return loanStatusDto;	
		} catch (Exception e) {
			throw new RuntimeException("Application Details Not Available");
			}
	}

	@Override
	public void updateStatusTrackingDetail(int applicationId, String status) {
		try {
			TrackingDetail trackingDetail = trackingDetailRepo.getTrackingDetailByAppId(applicationId);
			if (trackingDetail==null) {
				throw new HomeLoanException("Invalid User");
			}
			else {
				trackingDetailRepo.updateStatusTrackingDetail(applicationId, status);
				}
		} catch (HomeLoanException e) {
			throw e;
		}
		
	}


	@Override
	public List<StatusDto> getStatusTrackingDetail(StatusDto statusDto) {

		try {
			List<StatusDto> StatusDtoList = new ArrayList<StatusDto>();
			
			List<TrackingDetail> trackingDetail =  trackingDetailRepo.getStatusTrackingDetail(statusDto.getStatus());
			System.out.println("=======>Tracking"+trackingDetail);
			for (TrackingDetail trackingDetail2 : trackingDetail) {

				ApplicationDetail applicationDetail = applicationRepo.getApplicationDetailByAppId(trackingDetail2.getApplicationid());
				PersonalDetail personalDetail = applicationDetail.getPersonalDetail();
				System.out.println("======>"+trackingDetail2.getApplicationid());
				StatusDto loanStatusDto = new StatusDto();
				loanStatusDto.setEmailid(personalDetail.getEmailid());
				loanStatusDto.setApplicationDate(trackingDetail2.getApplicationDate());
				loanStatusDto.setapplicationid(trackingDetail2.getApplicationid());
				loanStatusDto.setStatus(trackingDetail2.getStatus());
				
				loanStatusDto.setFname(personalDetail.getFname());
				loanStatusDto.setLname(personalDetail.getLname());
				
				StatusDtoList.add(loanStatusDto);
				
		}	
		return StatusDtoList;	
					
		} catch (Exception e) {
			throw new RuntimeException("Application Details Not Available");
			}

	}


}
