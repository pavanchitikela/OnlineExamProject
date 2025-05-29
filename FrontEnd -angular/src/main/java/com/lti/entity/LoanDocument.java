package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOAN_DOCUMENTS database table.
 * 
 */
@Entity
@Table(name="LOAN_DOCUMENTS")
@NamedQuery(name="LoanDocument.findAll", query="SELECT l FROM LoanDocument l")
public class LoanDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int applicationid;

	private String aadhar;

	@Column(name="AGRMNT_TO_SALE")
	private String agrmntToSale;

	private String loa;

	@Column(name="NOC_FROM_BUILDER")
	private String nocFromBuilder;

	private String pan;

	private String voterid;

	//bi-directional one-to-one association to ApplicationDetail
	@OneToOne
	@MapsId
	@JoinColumn(name="APPLICATIONID")
	private ApplicationDetail applicationDetail;
	
	public LoanDocument() {
	}

	public int getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public String getAadhar() {
		return this.aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAgrmntToSale() {
		return this.agrmntToSale;
	}

	public void setAgrmntToSale(String agrmntToSale) {
		this.agrmntToSale = agrmntToSale;
	}

	public String getLoa() {
		return this.loa;
	}

	public void setLoa(String loa) {
		this.loa = loa;
	}

	public String getNocFromBuilder() {
		return this.nocFromBuilder;
	}

	public void setNocFromBuilder(String nocFromBuilder) {
		this.nocFromBuilder = nocFromBuilder;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getVoterid() {
		return this.voterid;
	}

	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	@Override
	public String toString() {
		return "LoanDocument [applicationid=" + applicationid + ", aadhar=" + aadhar + ", agrmntToSale=" + agrmntToSale
				+ ", loa=" + loa + ", nocFromBuilder=" + nocFromBuilder + ", pan=" + pan + ", voterid=" + voterid + "]";
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}

}