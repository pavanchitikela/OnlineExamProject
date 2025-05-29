package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ApplicationDetail;
import com.lti.entity.TrackingDetail;

@Repository
public class TrackingDetailRepoImpl implements TrackingDetailRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<TrackingDetail> getAllTrackingDetail() {	//done
		Query query = entityManager.createQuery("from TrackingDetail");
		List<TrackingDetail> trackingDetail = query.getResultList();
		return trackingDetail;
	}
	
	@Override
	public TrackingDetail getTrackingDetailByAppId(int applicationId) {		//done
		TrackingDetail trackingDetail = entityManager.find(TrackingDetail.class, applicationId);
		return trackingDetail;
	}


	@Override
	public List<TrackingDetail> getStatusTrackingDetail(String status) {	//done
		Query query = entityManager.createQuery("from TrackingDetail where status=:status").setParameter("status", status);
		List<TrackingDetail> trackingDetails= query.getResultList();
		return trackingDetails;
	}

	@Transactional
	public void updateStatusTrackingDetail(int applicationId, String updatedStatus) {	//done
		TrackingDetail trackingDetail = entityManager.find(TrackingDetail.class, applicationId);
		trackingDetail.setStatus(updatedStatus);
		entityManager.merge(trackingDetail);
	}

	@Transactional
	public void insertTrackingDetail(TrackingDetail trackingDetail, int applicationId) {	//done

		ApplicationDetail applicationDetail = entityManager.find(ApplicationDetail.class, applicationId);
		
		TrackingDetail trackingDetail2 = trackingDetail;
		trackingDetail2.setApplicationid(applicationId);
		trackingDetail2.setApplicationDetail(applicationDetail);
		entityManager.merge(trackingDetail2);
		
	}

	@Override
	public List<Object> getStatusByEmail(String emailid) {
		
	Query query = entityManager.createNativeQuery("select p.emailid, a.applicationid, t.application_date, t.status "
			+ "from personal_details p, application_details a, tracking_details t "
			+ "where p.emailid=a.emailid and a.applicationid=t.applicationid and p.emailid="+emailid);
		
		List<Object> obj = query.getResultList();
		
		return obj;
	}

}
