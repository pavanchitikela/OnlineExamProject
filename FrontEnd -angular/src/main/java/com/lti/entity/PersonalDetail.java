package com.lti.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the PERSONAL_DETAILS database table.
 * 
 */
@Entity
@Table(name="PERSONAL_DETAILS")
@NamedQuery(name="PersonalDetail.findAll", query="SELECT p FROM PersonalDetail p")
public class PersonalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String emailid;

	private String aadhar;

	//@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "DATE")
	private LocalDate dob;

	private String fname;

	private String gender;

	private String lname;

	private String mname;

	private String mobile;

	private String nationality;

	private String pan;

	private String password;

	//bi-directional many-to-one association to ApplicationDetail
	@OneToMany(mappedBy="personalDetail")
	private Set<ApplicationDetail> applicationDetails;
							
	//bi-directional many-to-one association to EmploymentDetail
	@OneToMany(mappedBy="personalDetail")
	private Set<EmploymentDetail> employmentDetails;

	@JsonIgnore
	public Set<EmploymentDetail> getEmploymentDetails() {
		return employmentDetails;
	}

	public void setEmploymentDetails(Set<EmploymentDetail> employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

	public PersonalDetail() {
	}

	public PersonalDetail(String emailid, String mobile) {
		super();
		this.emailid = emailid;
		this.mobile = mobile;
	}
	public PersonalDetail(String emailid, String aadhar, LocalDate dob, String fname, String gender, String lname,
			String mname, String mobile, String nationality, String pan, String password) {
		super();
		this.emailid = emailid;
		this.aadhar = aadhar;
		this.dob = dob;
		this.fname = fname;
		this.gender = gender;
		this.lname = lname;
		this.mname = mname;
		this.mobile = mobile;
		this.nationality = nationality;
		this.pan = pan;
		this.password = password;
	}
	
	public String getEmailid() {
		return this.emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getAadhar() {
		return this.aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public Set<ApplicationDetail> getApplicationDetails() {
		return this.applicationDetails;
	}

	public void setApplicationDetails(Set<ApplicationDetail> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public ApplicationDetail addApplicationDetail(ApplicationDetail applicationDetail) {
		getApplicationDetails().add(applicationDetail);
		applicationDetail.setPersonalDetail(this);

		return applicationDetail;
	}

	public ApplicationDetail removeApplicationDetail(ApplicationDetail applicationDetail) {
		getApplicationDetails().remove(applicationDetail);
		applicationDetail.setPersonalDetail(null);

		return applicationDetail;
	}

	public EmploymentDetail addEmploymentDetail(EmploymentDetail employmentDetail) {
		getEmploymentDetails().add(employmentDetail);
		employmentDetail.setPersonalDetail(this);

		return employmentDetail;
	}

	public EmploymentDetail removeEmploymentDetail(EmploymentDetail employmentDetail) {
		getEmploymentDetails().remove(employmentDetail);
		employmentDetail.setPersonalDetail(null);

		return employmentDetail;
	}

	@Override
	public String toString() {
		return "PersonalDetail [emailid=" + emailid + ", aadhar=" + aadhar + ", dob=" + dob + ", fname=" + fname
				+ ", gender=" + gender + ", lname=" + lname + ", mname=" + mname + ", mobile=" + mobile
				+ ", nationality=" + nationality + ", pan=" + pan + ", password=" + password + "]";
	}
}