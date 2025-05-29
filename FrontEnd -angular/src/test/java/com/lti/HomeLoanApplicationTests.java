package com.lti;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dto.*;
import com.lti.entity.*;
import com.lti.repository.*;

@SpringBootTest
class HomeLoanApplicationTests {

	@Autowired	ApplicationDetailRepo 	appDetRepo;
	@Autowired	LoanRequirementRepo		loanReqRepo;
	@Autowired	TrackingDetailRepo 		trackingDetRepo;
	@Autowired	PersonalDetailRepo 		personalDetRepo;
	@Autowired	EmploymentDetailRepo 	employDetRepo;
	@Autowired	HomeLoanRepo 			insertIntoHomeLoanRepo;
	@Autowired	PropertyDetailRepo 		propertyDetailRepository;
	@Autowired	SanctionedDetailRepo 	sanctionedDeatailRepository;
	@Autowired 	LoanDocumentRepo 		loanDocumentReopsitory;
	@Autowired	AdminLoginRepo 			adminLoginRepo;

	@PersistenceContext	EntityManager 	entityManager;

	@Test
	void getAllApplicationDetailContextLoads101() { // working
		List<ApplicationDetail> allApplicationDetails;
		allApplicationDetails = appDetRepo.getAllApplicationDetail();

		for (ApplicationDetail applicationDetail : allApplicationDetails) {
			System.out.println("Application Id -" + applicationDetail.getApplicationid());
			System.out.println("email Id -" + applicationDetail.getPersonalDetail().getEmailid());
			System.out.println("***************************************");
		}
	}

	@Test
	void getApplicationDetailByAppIdContextLoads102() { // working
		ApplicationDetail getApplicationDetailById;
		getApplicationDetailById = appDetRepo.getApplicationDetailByAppId(101);
		System.out.println(getApplicationDetailById.getApplicationid());
		System.out.println(getApplicationDetailById.getPersonalDetail().getEmailid());
		System.out.println("***************************************");
	}

	@Test
	void getApplicationDetailByEmailContextLoads103() { // working
		List<ApplicationDetail> getApplicationDetailByEmail = appDetRepo.getApplicationDetailByEmail("A@B.COM");
		for (ApplicationDetail applicationDetail : getApplicationDetailByEmail) {
			System.out.println(applicationDetail.getApplicationid());
			System.out.println(applicationDetail.getPersonalDetail().getEmailid());
			System.out.println("***************************************");
		}
	}

	@Test
	void totalApplicationDetailContextLoads104() { // working
		int total = appDetRepo.totalApplicationDetail();
		System.out.println("total is " + total);
	}

	@Test
	void insertApplicationDetailContextLoads105() { // working

		appDetRepo.insertApplicationDetail("A@B.COM");
		System.out.println("Application Submitted");
	}

	@Test
	void getAllLoanRequirementContextLoads201() { // working
		List<LoanRequirement> loanReq;
		loanReq = loanReqRepo.getAllLoanRequirement();

		for (LoanRequirement loanRequirement : loanReq) {
			System.out.println(loanRequirement.getApplicationid() + " " + loanRequirement.getEligibleAmount() + " "
					+ loanRequirement.getLoanTenure() + " " + loanRequirement.getRateOfInterest() + " "
					+ loanRequirement.getRequiredAmount());
		}
	}

	@Test
	void getLoanRequirementContextLoads202() { // working
		LoanRequirement loanRequirement = loanReqRepo.getLoanRequirement(102);
		System.out.println(loanRequirement.getApplicationid());
		System.out.println(loanRequirement.getEligibleAmount());
		System.out.println(loanRequirement.getRequiredAmount());
		System.out.println(loanRequirement.getLoanTenure());
		System.out.println(loanRequirement.getRateOfInterest());
		System.out.println("***************************************");
	}

	@Test
	void insertLoanRequirementContextLoads203() { // working
		LoanRequirement loanRequirement = new LoanRequirement();

		loanRequirement.setEligibleAmount(100000);
		loanRequirement.setLoanTenure(10);
		loanRequirement.setRequiredAmount(110000);

		ApplicationDetail applicationDetail = new ApplicationDetail();
		applicationDetail.setLoanRequirement(loanRequirement);

		loanRequirement.setApplicationDetail(applicationDetail);
		loanRequirement.setApplicationid(applicationDetail.getApplicationid());

		loanReqRepo.addLoanRequirement(loanRequirement, 8);
	}

	@Test
	void getAllTrackingDetailContextLoads301() { // working
		List<TrackingDetail> trackingDet;
		trackingDet = trackingDetRepo.getAllTrackingDetail();

		for (TrackingDetail trackingDetail : trackingDet) {
			System.out.println(trackingDetail.getApplicationid() + " " + trackingDetail.getStatus() + " "
					+ trackingDetail.getApplicationDate() + " " + trackingDetail.getApprovedDate() + " "
					+ trackingDetail.getVerificationDate());
		}
	}

	@Test
	void updateStatusTrackingDetailContextLoads302() { // working
		trackingDetRepo.updateStatusTrackingDetail(102, "APPROVED");
		System.out.println("Status Update");
	}

	@Test
	void getTrackingDetailByAppIdContextLoad303() { // working
		TrackingDetail trackingDetail;
		trackingDetail = trackingDetRepo.getTrackingDetailByAppId(102);
		System.out.println(trackingDetail.getApplicationid());
		System.out.println(trackingDetail.getStatus());
		System.out.println(trackingDetail.getApplicationDate());
		System.out.println(trackingDetail.getApprovedDate());
		System.out.println(trackingDetail.getVerificationDate());
	}

	@Test
	void insertTrackingDetailContextLoad304() { // working

		TrackingDetail trackingDetail = new TrackingDetail();
		System.out.println(LocalDate.now());

		trackingDetail.setApprovedDate(LocalDate.now());
		trackingDetail.setStatus("PENDING");
		trackingDetail.setVerificationDate(LocalDate.of(2020, 12, 15));

		trackingDetRepo.insertTrackingDetail(trackingDetail, 102);

		System.out.println("Tracking Details Inserted Successfully");
	}

	@Test
	void getStatusTrackingDetailContextLoad305() { // working
		List<TrackingDetail> trackDet = trackingDetRepo.getStatusTrackingDetail("PENDING");

		for (TrackingDetail trackingDetail : trackDet) {
			System.out.println("trackingDetail.getApplicationid() " + trackingDetail.getApplicationid());
			System.out.println("trackingDetail.getStatus() " + trackingDetail.getStatus());

		}
	}
	
	@Test
	void getStatusByEmailContextLoad306(){
		
		PersonalDetail personalDetail = personalDetRepo.getPersonalDetailEmail("A@B.COM");
		
		List<ApplicationDetail> appDetail = appDetRepo.getApplicationDetailByEmail(personalDetail.getEmailid());
			
		for (ApplicationDetail applicationDetail : appDetail) {
			TrackingDetail trackingDetail = trackingDetRepo.getTrackingDetailByAppId(applicationDetail.getApplicationid());	
			StatusDto statusDto = new StatusDto();
			
			statusDto.setApplicationDate(trackingDetail.getApplicationDate());
			statusDto.setapplicationid(trackingDetail.getApplicationid());
			statusDto.setEmailid(applicationDetail.getPersonalDetail().getEmailid());
			statusDto.setStatus(trackingDetail.getStatus());
			
			System.out.println("\t statusDto"+statusDto);
		}
	
	}

	@Test
	void getAllPersonalDetailsContextLoads1() { // done

		List<PersonalDetail> personalDetail;
		personalDetail = personalDetRepo.getAllPersonalDetails();

		for (PersonalDetail personalDetail2 : personalDetail) {
			System.out.println("Fullname:" + personalDetail2.getFname() + " " + personalDetail2.getMname() + " "
					+ personalDetail2.getLname());
			System.out.println("Aadhar:" + personalDetail2.getAadhar());
			System.out.println("Pan:" + personalDetail2.getPan());
			System.out.println("DOB:" + personalDetail2.getDob());
			System.out.println("Gender:" + personalDetail2.getGender());
		}
	}

	@Test
	void insertPersonalDetailContextLoads2() { // done

		PersonalDetail personalDetail = new PersonalDetail("D@P.com", "321045671098", LocalDate.of(1998, 02, 24),
				"Shahir", "M", "Khan", "M", "7046507086", "India", "ZXCVB457N", "LOGIN123");
		personalDetRepo.insertPersonalDetail(personalDetail);
		System.out.println("Data inserted");
	}

	@Test
	void getPersonalDetailEmailContextLoads3() { // done
		PersonalDetail personalDetail = personalDetRepo.getPersonalDetailEmail("A@B.COM");
		System.out.println("=>personalDetails " + personalDetail);
		System.out.println("=>Fullname:" + personalDetail.getFname() + " " + personalDetail.getMname() + " "
				+ personalDetail.getLname());
		System.out.println("=>Aadhar:" + personalDetail.getAadhar());
		System.out.println("=>Pan:" + personalDetail.getPan());
		System.out.println("=>DOB:" + personalDetail.getDob());
		System.out.println("=>Gender:" + personalDetail.getGender());
	}

	@Test
	void updatePersonalDetailPasswordContextLoads4() { // done
		String mobile = "7654398765";
		personalDetRepo.updatePersonalDetailMobile("A@B.COM", mobile);
		System.out.println("Updated");
		System.out.println("=>mobile):" + mobile);
	}

	@Test
	void updatePersonalDetailPasswordContextLoads5() { // done
		String password = "QWE123@";
		personalDetRepo.updatePersonalDetailMobile("A@B.COM", password);
		System.out.println("Updated");
		System.out.println("=>Password:" + password);
	}

	@Test
	void getAllEmploymentDetailsContextLoads7() {
		List<EmploymentDetail> employmentDetail;
		employmentDetail = employDetRepo.getAllEmploymentDetails();

		for (EmploymentDetail employmentDetail2 : employmentDetail) {
			System.out.println("EmploymentType: " + employmentDetail2.getEmploymentType());
			System.out.println("Monthly Income: " + employmentDetail2.getMonthlyIncome());
			System.out.println("EmploymentType: " + employmentDetail2.getOrganisationName());
			System.out.println("EmploymentType: " + employmentDetail2.getApplicationDetail());
		}

	}

	@Test
	void getEmploymentDetailAppIDContextLoads9() {
		EmploymentDetail employmentDetail = employDetRepo.getEmploymentDetailAppID(101);

		System.out.println("==>EmploymentDetail: " + employmentDetail);

		System.out.println("EmploymentType: " + employmentDetail.getEmploymentType());
		System.out.println("Monthly Income: " + employmentDetail.getMonthlyIncome());
		System.out.println("EmploymentType: " + employmentDetail.getOrganisationName());
		System.out.println("EmploymentType: " + employmentDetail.getApplicationDetail());
	}

	@Test
	void AllPropertyDetail() { // working
		List<PropertyDetail> list = propertyDetailRepository.getAllPropertyDetail(); // right to left select query

		for (PropertyDetail propertyDetail2 : list) {
			System.out.println(propertyDetail2.getApplicationid());
			System.out.println(propertyDetail2.getPropertyLocation());
			System.out.println(propertyDetail2.getPropertyName());
			System.out.println(propertyDetail2.getPropertyCost());
			System.out.println("===================");
		}
	}

	@Test
	void PropertyDetailById() { // working
		PropertyDetail propertyDetail = propertyDetailRepository.getPropertyDetailByApplicationId(101); 
		System.out.println(propertyDetail.getPropertyLocation());
		System.out.println(propertyDetail.getPropertyName());
		System.out.println(propertyDetail.getPropertyCost());

	}

	@Test
	void InsertPropertyDetail() { // working

		PropertyDetail propertyDetail = new PropertyDetail();

		ApplicationDetail applicationDetail = new ApplicationDetail();

		propertyDetail.setApplicationid(applicationDetail.getApplicationid());
		propertyDetail.setPropertyCost(550000f);
		propertyDetail.setPropertyLocation("ShahiBaug");
		propertyDetail.setPropertyName("GokulDhamSoc");

		applicationDetail.setPropertyDetail(propertyDetail);
		propertyDetail.setApplicationDetail(applicationDetail);

		propertyDetailRepository.insertPropertyDetail(propertyDetail);

		System.out.println("Data inserted in PropertyDetails");

	}

	@Test
	void GetAllSanctionDetail() {
		List<SanctionedDetail> sanctionedDetailList = new ArrayList<>();
		sanctionedDetailList = sanctionedDeatailRepository.getAllSanctionedDetail();

		System.out.println("sanctionedDetailList" + sanctionedDetailList);

		for (SanctionedDetail sanctionedDetail : sanctionedDetailList) {

			System.out.println(sanctionedDetail.getBalanceAmount());

		}
	}

	@Test
	void InsertSanctionDetail() {
		SanctionedDetail sanctionedDetail = new SanctionedDetail();

		ApplicationDetail applicationDetail = appDetRepo.getApplicationDetailByAppId(61);
		System.out.println("\tapplication Details got Successfully" + applicationDetail);

		sanctionedDetail.setApplicationDetail(applicationDetail);
		sanctionedDetail.setBalanceAmount(50000f);
		sanctionedDetail.setEmi(500f);
		sanctionedDetail.setSanctionedAmount(1000f);

		Set<SanctionedDetail> sanctionedDetailSet = new HashSet<>();
		sanctionedDetailSet.add(sanctionedDetail);

		applicationDetail.setSanctionedDetail(sanctionedDetailSet);

		sanctionedDeatailRepository.insertSanctionedDetail(sanctionedDetail);
	}

	@Test
	void GetSanctionedDetailByApplicationId() {
		List<SanctionedDetail> sanctionedDetailList = sanctionedDeatailRepository.getSanctionedDetailByAppId(101);
		for (SanctionedDetail sanctionedDetail : sanctionedDetailList) {
			System.out.println(sanctionedDetail.getAccountNo());
			System.out.println(sanctionedDetail.getBalanceAmount());
		}
	}

	@Test
	void GetSanctionedDetailByAccountNumber() {
		SanctionedDetail sanctionedDetail = sanctionedDeatailRepository.getSanctionedDetailByAccountNo(999);
		System.out.println(sanctionedDetail.getAccountNo());
		System.out.println(sanctionedDetail.getApplicationDetail().getEmploymentDetail().getOrganisationName());
	}
	
	@Test
	void InsertLoanDocument() { // Working
		LoanDocument loanDocument = new LoanDocument();

		loanDocument.setApplicationid(103);
		loanDocument.setAadhar("789456123");
		loanDocument.setAgrmntToSale("Aggtosale104");
		loanDocument.setLoa("LOA104");
		loanDocument.setNocFromBuilder("NOC104");
		loanDocument.setPan("PAN104");
		loanDocument.setVoterid("VoterID104");

		loanDocumentReopsitory.insertLoanDocument(loanDocument);

		System.out.println("Data Inserted in Loan Document");

	}

	@Test
	void AllLoanDocuments() { // Working
		List<LoanDocument> list = loanDocumentReopsitory.getAllLoanDocument();

		for (LoanDocument loanDocument : list) {

			System.out.println(loanDocument.getApplicationid());
			System.out.println(loanDocument.getAadhar());
			System.out.println(loanDocument.getAgrmntToSale());
			System.out.println(loanDocument.getLoa());
			System.out.println(loanDocument.getNocFromBuilder());
			System.out.println(loanDocument.getPan());
			System.out.println(loanDocument.getVoterid());
			System.out.println("===================");

		}
	}

	@Test
	void GetLoanDocument() { // Working
		LoanDocument loanDocument = loanDocumentReopsitory.getLoanDocumentByApplicationId(11);
		System.out.println(loanDocument.getAadhar());
		System.out.println(loanDocument.getAgrmntToSale());
		System.out.println(loanDocument.getApplicationid());
		System.out.println(loanDocument.getLoa());
		System.out.println(loanDocument.getNocFromBuilder());
		System.out.println(loanDocument.getPan());
		System.out.println(loanDocument.getVoterid());

	}

	@Test
	void insertIntoHomeLoanViaAll() {

		PersonalDetail personalDetail = personalDetRepo.getPersonalDetailEmail("D@P.com");

		ApplicationDetail applicationDetail = new ApplicationDetail();

		EmploymentDetail employmentDetail = new EmploymentDetail();
		employmentDetail.setEmploymentType("Emp Type");
		employmentDetail.setMonthlyIncome(0000);
		employmentDetail.setRetirementAge(99);
		employmentDetail.setApplicationid(applicationDetail.getApplicationid());
		employmentDetail.setApplicationDetail(applicationDetail);
		employmentDetail.setPersonalDetail(personalDetail);

		LoanRequirement loanRequirement = new LoanRequirement();
		loanRequirement.setEligibleAmount(employmentDetail.getMonthlyIncome() * 60 * 0.6f);
		loanRequirement.setLoanTenure(99);
		loanRequirement.setRateOfInterest(8.5f);
		loanRequirement.setApplicationid(applicationDetail.getApplicationid());
		loanRequirement.setApplicationDetail(applicationDetail);

		PropertyDetail propertyDetail = new PropertyDetail();
		propertyDetail.setPropertyCost(00000f);
		propertyDetail.setPropertyLocation("Mumbai");
		propertyDetail.setApplicationid(applicationDetail.getApplicationid());
		propertyDetail.setApplicationDetail(applicationDetail);

		LoanDocument loanDocument = new LoanDocument();
		loanDocument.setAadhar("aadhar.jpeg");
		loanDocument.setAgrmntToSale("Agg2sale.jpg");
		loanDocument.setLoa("loa.jpg");
		loanDocument.setNocFromBuilder("noc.jpg");
		loanDocument.setPan("pan.jpg");
		loanDocument.setVoterid("voterId");
		loanDocument.setApplicationid(applicationDetail.getApplicationid());
		loanDocument.setApplicationDetail(applicationDetail);

		Set<ApplicationDetail> applicationDetailSet = new HashSet<ApplicationDetail>();

		applicationDetailSet.add(applicationDetail);

		applicationDetail.setPersonalDetail(personalDetail);
		personalDetail.setApplicationDetails(applicationDetailSet);

		TrackingDetail trackingDetail = new TrackingDetail();
		trackingDetail.setApplicationid(applicationDetail.getApplicationid());
		trackingDetail.setApplicationDetail(applicationDetail);
		applicationDetail.setTrackingDetail(trackingDetail);

		insertIntoHomeLoanRepo.insertIntoHomeLoanViaAll(applicationDetail, employmentDetail, loanRequirement,
				propertyDetail, loanDocument);

	}

	@Test
	void testEMI() {

		float principal = 1200;
		float rate = 10;
		int time = 1;
		rate = rate / (12 * 100);
		time = time * 12;

		float emi = (float) ((principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1));
		
		System.out.print("\tEMI is= " + emi + "\n");
		System.out.print("\tTotal Payable  is= " + 12*emi + "\n");
		
	}

	@Test
	void getfullDetails() {

		int i = 61;

		ApplicationDetail applicationDetail = appDetRepo.getApplicationDetailByAppId(i);
		EmploymentDetail employmentDetail = employDetRepo.getEmploymentDetailAppID(i);
		LoanDocument loanDocument = loanDocumentReopsitory.getLoanDocumentByApplicationId(i);
		LoanRequirement loanRequirement = loanReqRepo.getLoanRequirement(i);
		List<SanctionedDetail> sanctionedDetail = sanctionedDeatailRepository.getSanctionedDetailByAppId(i);
		TrackingDetail trackingDetail = trackingDetRepo.getTrackingDetailByAppId(i);
		PropertyDetail propertyDetail = propertyDetailRepository.getPropertyDetailByApplicationId(i);

		System.out.println(applicationDetail + "\n" + employmentDetail + "\n" + loanDocument + "\n" + loanRequirement
				+ "\n" + trackingDetail + "\n" + propertyDetail);

		for (SanctionedDetail sanctionedDetail2 : sanctionedDetail) {
			System.out.println(sanctionedDetail2.getAccountNo());
		}

	}

	@Test
	void AdminTest() {
		AdminLogin adminLogin = adminLoginRepo.loginAdmin("ad123");
		System.out.println(adminLogin.getPassword());
	}

	
}
