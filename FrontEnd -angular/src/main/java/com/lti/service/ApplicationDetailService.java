package com.lti.service;

import java.util.List;

import com.lti.dto.StatusDto;

public interface ApplicationDetailService {

	public void insertApplicationDetail(String emailid);
	public List<StatusDto> getAllApplicationDetail(String emailid);
}
