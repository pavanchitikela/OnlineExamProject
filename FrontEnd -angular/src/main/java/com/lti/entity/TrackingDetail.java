package com.lti.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="TRACKING_DETAILS")
@NamedQuery(name="TrackingDetail.findAll", query="SELECT t FROM TrackingDetail t")
public class TrackingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int applicationid;

//	@Temporal(TemporalType.DATE)
	@Column(name="APPLICATION_DATE", columnDefinition = "DATE")
	private LocalDate applicationDate = LocalDate.now();

	@Override
	public String toString() {
		return "TrackingDetail [applicationid=" + applicationid + ", applicationDate=" + applicationDate
				+ ", approvedDate=" + approvedDate + ", status=" + status + ", verificationDate=" + verificationDate
				+ "]";
	}

	//	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE", columnDefinition = "DATE")
	private LocalDate approvedDate;

	private String status="PENDING";

//	@Temporal(TemporalType.DATE)
	@Column(name="VERIFICATION_DATE", columnDefinition = "DATE")
	private LocalDate verificationDate;

	//bi-directional one-to-one association to ApplicationDetail
	@OneToOne//(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="APPLICATIONID")
	private ApplicationDetail applicationDetail;

	public TrackingDetail() {
	}

	public int getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public LocalDate getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getVerificationDate() {
		return this.verificationDate;
	}

	public void setVerificationDate(LocalDate verificationDate) {
		this.verificationDate = verificationDate;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}
	
}