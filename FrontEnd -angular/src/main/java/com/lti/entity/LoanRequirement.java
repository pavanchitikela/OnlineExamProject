package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOAN_REQUIREMENTS database table.
 * 
 */
@Entity
@Table(name="LOAN_REQUIREMENTS")
@NamedQuery(name="LoanRequirement.findAll", query="SELECT l FROM LoanRequirement l")
public class LoanRequirement implements Serializable {
	@Override
	public String toString() {
		return "LoanRequirement [applicationid=" + applicationid + ", eligibleAmount=" + eligibleAmount
				+ ", loanTenure=" + loanTenure + ", rateOfInterest=" + rateOfInterest + ", requiredAmount="
				+ requiredAmount + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int applicationid;

	@Column(name="ELIGIBLE_AMOUNT")
	private float eligibleAmount;

	@Column(name="LOAN_TENURE")
	private int loanTenure;

	@Column(name="RATE_OF_INTEREST")
	private float rateOfInterest=8.5f;

	@Column(name="REQUIRED_AMOUNT")
	private float requiredAmount;

	//bi-directional one-to-one association to ApplicationDetail
	@OneToOne//(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="APPLICATIONID")
	private ApplicationDetail applicationDetail;

	public LoanRequirement() {
	}

	public int getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public float getEligibleAmount() {
		return this.eligibleAmount;
	}

	public void setEligibleAmount(float eligibleAmount) {
		this.eligibleAmount = eligibleAmount;
	}

	public int getLoanTenure() {
		return this.loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public float getRateOfInterest() {
		return this.rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public float getRequiredAmount() {
		return this.requiredAmount;
	}

	public void setRequiredAmount(float requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}

}