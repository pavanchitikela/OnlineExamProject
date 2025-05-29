package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lti.dto.*;
import com.lti.service.*;
import com.lti.entity.PersonalDetail;
import com.lti.exception.HomeLoanException;


@RestController
@CrossOrigin //(origins = "http://localhost:4200")  //@CrossOrigin(origins = "http://localhost:4200")
public class HomeLoanController {

	@Autowired private ApplicationDetailService applicationDetailService;
	@Autowired private TrackingDetailService trackingDetailService;
	@Autowired private PersonalDetailService personalDetailService;
	@Autowired private SanctionedDetailService sanctionedDetailService;
	@Autowired private AdminService adminService;
	@Autowired private LoanApplicaionService loanApplicaionService;
	
	@PostMapping(path="/register") 
	public String register(@RequestBody PersonalDetail personalDetail) {
	try {			
		return personalDetailService.userRegisterService(personalDetail);
		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	}

/*		*******************************************AnotherWay(But use JSONIgnore)*************************************/
  
//	@GetMapping("/getdetail/{emailId}")
//	@ResponseBody
//	public PersonalDetail getPersoanlDetailByEmail( @PathVariable("emailId") String emailid) {
//	try {	
//		//personalDetailService.getPersonalDetailByEmail(emailId);
//		
//		return personalDetailService.getPersonalDetailByEmailService(emailid);
//	
//		} catch (Exception e) {
//			throw new RuntimeException("Invalid Email-Id");
//		}
//	}
	/*		*******************************************AnotherWay(But use JSONIgnore)*************************************/
	  
	
	@PostMapping("/getdetail")
	public PersonalDetail getDetailByEmail(@RequestBody PersonalDetail PersonalDetail) {
		try {	
			return personalDetailService.getPersonalDetailByEmailService(PersonalDetail.getEmailid());
			}
		catch (HomeLoanException e) {
			throw new RuntimeException("Invalid Email-Id");
				}
	}
	
	@PostMapping("/userlogin")
	public LoginDto loginController(@RequestBody LoginDto loginDto) {
		try {
			LoginDto loginDto2 = personalDetailService.userloginService(loginDto.getEmailid(), loginDto.getPassword());
			return loginDto2 ;
		}
		catch (HomeLoanException e) {
			throw new HomeLoanException(e.getMessage());
		}

	}
	
	
	@PostMapping("/updatepassword")	
	public String updatePassword(@RequestBody PasswordDto passwordDto) {
		System.out.println("controller :\t"+passwordDto);
		try {
			personalDetailService.updatePasswordService(passwordDto.getEmailid(), passwordDto.getPassword(), passwordDto.getNewPassword());
		return "Sucessful";
		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/track") 
	public StatusDto trackDetail(@RequestBody StatusDto statusDto) {
		try {
			StatusDto loanStatus = trackingDetailService.getTrackingDetailByAppId(statusDto.getapplicationid());
			return loanStatus;
		} catch (RuntimeException e) {
			throw e;//new RuntimeException(e);
		}	
	}
	
	@PostMapping(path="/track/update")	
	public String updateTrackDetailStatus(@RequestBody StatusDto statusDto) {
		try {
			trackingDetailService.updateStatusTrackingDetail(statusDto.getapplicationid(), statusDto.getStatus());
			return "Update Sucessful";
		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path="/sanction/status")
	public SanctionDto getSanctionedDetails(@RequestBody SanctionDto sanctionDto) {
		try {
			SanctionDto sanctionDto2 = sanctionedDetailService.getSanctionedDetailByAccNo(sanctionDto.getAccountNo());
			return sanctionDto2;
		} catch (HomeLoanException e) {
			throw e;
		}
	}
	
	@PostMapping(path="/adminlogin")
	public String AdminLogin(@RequestBody AdminDto adminDto) {    
		try {
			adminService.adminLogin(adminDto.getAdminid(), adminDto.getPassword());
			return "Admin Login Sucessful";

		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path = "/addapplication")
	public String addApplication(@RequestBody LoanApplicationDto loanApplicationDto) {	
		try {
			loanApplicaionService.addLoanApplication(loanApplicationDto);
			return "Application Successfull";			
			
		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	
	}

	@PostMapping(path = "/getappdetails")
	public List<StatusDto> getAllApplicationDetails(@RequestBody StatusDto statusDto){
		List<StatusDto> statusDtoList = null;
		try {
			System.out.println("\t"+statusDto.getEmailid());
			statusDtoList = applicationDetailService.getAllApplicationDetail(statusDto.getEmailid());
//			return statusDtoList;
		}catch(HomeLoanException e) {
			throw e;
		}return statusDtoList;
	}	
	
	@PostMapping("/changepassword")
	public String changePassword(@RequestBody PasswordDto passwordDto) {
		System.out.println("controller :\t"+passwordDto);
		try {
			personalDetailService.updatePasswordService(passwordDto.getEmailid(), passwordDto.getPassword(), passwordDto.getNewPassword());
		return "Sucessful";
		} catch (HomeLoanException e) {
			return e.getMessage();
		}
	}
	

	@PostMapping(path= "/getappdetails/status")
	public List<StatusDto> getTrackingDetailsByStatus(@RequestBody StatusDto statusDto){
		try {
			System.out.println("\t"+statusDto.getStatus());
			List<StatusDto> statusDtoList = trackingDetailService.getStatusTrackingDetail(statusDto);
			return statusDtoList;
		}catch(HomeLoanException e) {
			throw e;
		}
	}
	
}
