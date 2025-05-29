package com.lti.service;

import java.util.List;

import com.lti.dto.StatusDto;

public interface TrackingDetailService {
	
	public StatusDto 		getTrackingDetailByAppId(int applicationId);	
	public void updateStatusTrackingDetail(int applicationId, String status);
	public List<StatusDto> getStatusTrackingDetail(StatusDto statusDto);
}
