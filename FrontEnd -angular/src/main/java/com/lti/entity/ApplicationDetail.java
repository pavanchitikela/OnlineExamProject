package com.lti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="APPLICATION_DETAILS")
@NamedQuery(name="ApplicationDetail.findAll", query="SELECT a FROM ApplicationDetail a")
public class ApplicationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_generator")
    @SequenceGenerator(name = "my_generator", sequenceName = "MY_SEQUENCE",  allocationSize = 1)
	private int applicationid;

	//bi-directional many-to-one association to PersonalDetail
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EMAILID")
	private PersonalDetail personalDetail;

		//bi-directional one-to-one association to EmploymentDetail
	@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmploymentDetail employmentDetail;

		//bi-directional one-to-one association to LoanDocument
	@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private LoanDocument loanDocument;

		//bi-directional one-to-one association to LoanRequirement
	@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private LoanRequirement loanRequirement;

		//bi-directional one-to-one association to PropertyDetail
	@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PropertyDetail propertyDetail;

		//bi-directional one-to-one association to SactionedDetail
	//@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@OneToMany(mappedBy="applicationDetail", fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private  Set<SanctionedDetail> sanctionedDetail;

		//bi-directional one-to-one association to TrackingDetail
	@OneToOne(mappedBy="applicationDetail", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TrackingDetail trackingDetail;

	public ApplicationDetail() {
	}

//	public ApplicationDetail(int applicationid, PersonalDetail personalDetail) {
//		super();
//		this.applicationid = applicationid;
//		this.personalDetail = personalDetail;
//	}

	public int getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}

	public PersonalDetail getPersonalDetail() {
		return this.personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}

	public EmploymentDetail getEmploymentDetail() {
		return this.employmentDetail;
	}

	public void setEmploymentDetail(EmploymentDetail employmentDetail) {
		this.employmentDetail = employmentDetail;
	}

	public LoanDocument getLoanDocument() {
		return this.loanDocument;
	}

	public void setLoanDocument(LoanDocument loanDocument) {
		this.loanDocument = loanDocument;
	}

	public LoanRequirement getLoanRequirement() {
		return this.loanRequirement;
	}

	public void setLoanRequirement(LoanRequirement loanRequirement) {
		this.loanRequirement = loanRequirement;
	}

	public PropertyDetail getPropertyDetail() {
		return this.propertyDetail;
	}

	public void setPropertyDetail(PropertyDetail propertyDetail) {
		this.propertyDetail = propertyDetail;
	}

	public Set<SanctionedDetail> getSanctionedDetail() {
		return this.sanctionedDetail;
	}

	public void setSanctionedDetail(Set<SanctionedDetail> sanctionedDetail) {
		this.sanctionedDetail = sanctionedDetail;
	}

	public SanctionedDetail addSanctionedDetail(SanctionedDetail sanctionedDetail) {
		getSanctionedDetail().add(sanctionedDetail);
		sanctionedDetail.setApplicationDetail(this);

		return sanctionedDetail;
	}

	public SanctionedDetail removeSanctionedDetail(SanctionedDetail sanctionedDetail) {
		getSanctionedDetail().remove(sanctionedDetail);
		sanctionedDetail.setApplicationDetail(null);

		return sanctionedDetail;
	}
	
	public TrackingDetail getTrackingDetail() {
		return this.trackingDetail;
	}

	public void setTrackingDetail(TrackingDetail trackingDetail) {
		this.trackingDetail = trackingDetail;
	}

	@Override
	public String toString() {
		return "ApplicationDetail [applicationid=" + applicationid + "]";
	}

}