package com.lti.repository;

import java.util.List;

import com.lti.entity.TrackingDetail;

public interface TrackingDetailRepo {
	
	public List<TrackingDetail> getAllTrackingDetail();
	public TrackingDetail 		getTrackingDetailByAppId(int applicationId);
	public List<TrackingDetail> getStatusTrackingDetail(String status);
	
	public void updateStatusTrackingDetail(int applicationId, String status);
	public void insertTrackingDetail(TrackingDetail trackingDetail, int applicationId);
	
	public List<Object> getStatusByEmail(String emailid);
}