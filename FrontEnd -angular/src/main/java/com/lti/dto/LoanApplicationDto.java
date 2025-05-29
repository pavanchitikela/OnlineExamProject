package com.lti.dto;

public class LoanApplicationDto {

		private	String emailid;				//from PersonalDet
		
		private String employmentType;		//from EmpDet
		private float monthlyIncome;
		private String organisationName;
		private String organisationType;
		private int retirementAge;			//from EmpDet
		
		private String aadhar;				//from LoanDoc
		private String agrmntToSale;
		private String loa;
		private String nocFromBuilder;
		private String pan;
		private String voterid;				//from LoanDoc
		
		private int loanTenure;				//from LoanReq
		private float requiredAmount;		//from LoanReq
		
		private float propertyCost;			//from PropDet
		private String propertyLocation;
		private String propertyName;		//from PropDet
		
		
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getEmploymentType() {
			return employmentType;
		}
		public void setEmploymentType(String employmentType) {
			this.employmentType = employmentType;
		}
		public float getMonthlyIncome() {
			return monthlyIncome;
		}
		public void setMonthlyIncome(float monthlyIncome) {
			this.monthlyIncome = monthlyIncome;
		}
		public String getOrganisationName() {
			return organisationName;
		}
		public void setOrganisationName(String organisationName) {
			this.organisationName = organisationName;
		}
		public String getOrganisationType() {
			return organisationType;
		}
		public void setOrganisationType(String organisationType) {
			this.organisationType = organisationType;
		}
		public int getRetirementAge() {
			return retirementAge;
		}
		public void setRetirementAge(int retirementAge) {
			this.retirementAge = retirementAge;
		}
		public String getAadhar() {
			return aadhar;
		}
		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
		}
		public String getAgrmntToSale() {
			return agrmntToSale;
		}
		public void setAgrmntToSale(String agrmntToSale) {
			this.agrmntToSale = agrmntToSale;
		}
		public String getLoa() {
			return loa;
		}
		public void setLoa(String loa) {
			this.loa = loa;
		}
		public String getNocFromBuilder() {
			return nocFromBuilder;
		}
		public void setNocFromBuilder(String nocFromBuilder) {
			this.nocFromBuilder = nocFromBuilder;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public String getVoterid() {
			return voterid;
		}
		public void setVoterid(String voterid) {
			this.voterid = voterid;
		}
		public int getLoanTenure() {
			return loanTenure;
		}
		public void setLoanTenure(int loanTenure) {
			this.loanTenure = loanTenure;
		}
		public float getRequiredAmount() {
			return requiredAmount;
		}
		public void setRequiredAmount(float requiredAmount) {
			this.requiredAmount = requiredAmount;
		}
		public float getPropertyCost() {
			return propertyCost;
		}
		public void setPropertyCost(float propertyCost) {
			this.propertyCost = propertyCost;
		}
		public String getPropertyLocation() {
			return propertyLocation;
		}
		public void setPropertyLocation(String propertyLocation) {
			this.propertyLocation = propertyLocation;
		}
		public String getPropertyName() {
			return propertyName;
		}
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		
	
}
