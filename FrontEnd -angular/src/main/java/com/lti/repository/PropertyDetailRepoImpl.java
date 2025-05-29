package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.PropertyDetail;

@Repository
public class PropertyDetailRepoImpl implements PropertyDetailRepo {

	
	@PersistenceContext
	EntityManager entityManager;
		
	

	@Override
	public List<PropertyDetail> getAllPropertyDetail() {
		Query query = entityManager.createQuery("from PropertyDetail"); // select * from table name
		List<PropertyDetail> propertyDetailList = query.getResultList();
		return propertyDetailList;
	}

	@Override
	public PropertyDetail getPropertyDetailByApplicationId(int applicationId) {
		PropertyDetail propertyDetail = entityManager.find(PropertyDetail.class, applicationId);
		return propertyDetail;
	}

			
	@Transactional
	public void insertPropertyDetail(PropertyDetail propertyDetail) {
		
//		int appID = propertyDetail.getApplicationid();
//		ApplicationDetail applicationDetail=entityManager.find(ApplicationDetail.class, appID);
//		PropertyDetail propertyDetail2 = propertyDetail;
//		propertyDetail2.setApplicationDetail(applicationDetail);
				
		entityManager.persist(propertyDetail);
		
	}


}
