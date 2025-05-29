package com.lti.repository;

import java.util.List;

import com.lti.entity.SanctionedDetail;

public interface SanctionedDetailRepo {
	
	public List<SanctionedDetail> getAllSanctionedDetail();
	public void insertSanctionedDetail(SanctionedDetail sanctionDetail);
	public List<SanctionedDetail> getSanctionedDetailByAppId(int applicationId);
	public SanctionedDetail getSanctionedDetailByAccountNo(int AccountNo);
	
}
