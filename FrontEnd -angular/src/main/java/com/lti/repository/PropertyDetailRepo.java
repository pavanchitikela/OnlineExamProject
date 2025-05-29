package com.lti.repository;

import java.util.List;

import com.lti.entity.PropertyDetail;

public interface PropertyDetailRepo {

	public List<PropertyDetail> getAllPropertyDetail();
	public PropertyDetail getPropertyDetailByApplicationId(int applicationId);
	public void insertPropertyDetail (PropertyDetail propertyDetail);
}
