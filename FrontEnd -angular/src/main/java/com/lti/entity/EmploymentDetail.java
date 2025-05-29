package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="EMPLOYMENT_DETAILS")
@NamedQuery(name="EmploymentDetail.findAll", query="SELECT e FROM EmploymentDetail e")
public class EmploymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int applicationid;
	
	@Column(name="EMPLOYMENT_TYPE")
	private String employmentType;

	@Column(name="MONTHLY_INCOME")
	private float monthlyIncome;

	@Column(name="ORGANISATION_NAME")
	private String organisationName;

	@Column(name="ORGANISATION_TYPE")
	private String organisationType;

	@Column(name="RETIREMENT_AGE")
	private int retirementAge;

	//bi-directional one-to-one association to ApplicationDetail
	@OneToOne//(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="APPLICATIONID")
	private ApplicationDetail applicationDetail;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EMAILID")
	private PersonalDetail personalDetail;

	public EmploymentDetail() {
	}

	public int getApplicationid() {
		return applicationid;
	}


	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}


	public String getEmploymentType() {
		return this.employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public float getMonthlyIncome() {
		return this.monthlyIncome;
	}

	public void setMonthlyIncome(float monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getOrganisationName() {
		return this.organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationType() {
		return this.organisationType;
	}

	public void setOrganisationType(String organisationType) {
		this.organisationType = organisationType;
	}

	public int getRetirementAge() {
		return this.retirementAge;
	}

	public void setRetirementAge(int retirementAge) {
		this.retirementAge = retirementAge;
	}

	public ApplicationDetail getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
	}
	
	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}
	
	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}

	@Override
	public String toString() {
		return "EmploymentDetail [applicationid=" + applicationid + ", employmentType=" + employmentType
				+ ", monthlyIncome=" + monthlyIncome + ", organisationName=" + organisationName + ", organisationType="
				+ organisationType + ", retirementAge=" + retirementAge + "]";
	}
	

}