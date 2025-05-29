package com.lti.repository;

import java.util.List;

import com.lti.entity.ApplicationDetail;

public interface ApplicationDetailRepo {

	public List<ApplicationDetail> 	getAllApplicationDetail(); 						//done
	public List<ApplicationDetail> 	getApplicationDetailByEmail(String emailId);	//done
	public ApplicationDetail 		getApplicationDetailByAppId(int applicationid);	//done
	//public void insertApplicationDetail(int appId, String emailId);				//done
	public int	totalApplicationDetail();											//done
	public void insertApplicationDetail(String emailId);
	
}