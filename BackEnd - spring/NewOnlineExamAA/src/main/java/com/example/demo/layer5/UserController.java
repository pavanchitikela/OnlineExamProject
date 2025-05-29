package com.example.demo.layer5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.ExamUser;
import com.example.demo.layer4.UserService;
import com.example.demo.layer4.Exceptions.UserAlreadyExistsException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping(path="/getUser/{myUserId}")
	@ResponseBody
	public ExamUser getUserController(@PathVariable("myUserId") int userId) {
		ExamUser eu=userServ.getUserByUserIdService(userId);
		return eu;
	}
	
	@PostMapping(path="/login")  // For login check
	public ExamUser validation(@RequestBody ExamUser user)
	{
		ExamUser userFromDatabase=null;
		List<ExamUser> userList=userServ.userValdationService(user.getUsername(), user.getPassword());
		for(ExamUser userIter:userList) {
		  if(userIter!=null) {
		   userFromDatabase=userIter;
		   System.out.println("user is :"+userFromDatabase);
		   System.out.println("userId : "+userFromDatabase.getUserId());
		   System.out.println("username : "+userFromDatabase.getUsername());
		   System.out.println("Password : "+userFromDatabase.getPassword());
		  }
		}
		return userFromDatabase;
	}

	@PostMapping(path="/addUser")  // For Registration
	public String addUser(@RequestBody ExamUser user) throws UserAlreadyExistsException {
		System.out.println("User Controller....Understanding client and talking to service layer...");
		ExamUser eu = new ExamUser();
		eu.setMobile(user.getMobile());
		eu.setState(user.getState());
		eu.setCity(user.getCity());
		eu.setQual(user.getQual());
		eu.setEmail(user.getEmail());
		eu.setUsername(user.getUsername());
		eu.setYoc(user.getYoc());
		eu.setPassword(user.getPassword());
		try {
		userServ.addUserService(eu);
		}
		catch (UserAlreadyExistsException e) {   
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  return "registration success";
	}

     @GetMapping(path="/getAllUsers")
	 @ResponseBody
     public List<ExamUser> getAllUsers() {
	  List<ExamUser> euList=userServ.getAllUsersService();	
	  return euList;
	}
	 @DeleteMapping(path="/deleteUser/{myUserId}")
	 @ResponseBody
	 void deleteUser(@PathVariable("myUserId") int UserId) {
		 userServ.deleteUserByUserIdService(UserId);
	}
	
	 @PutMapping(path="/changeUserPassword")
	 @ResponseBody
	 void updateUserPassword(@RequestBody ExamUser myUser){  // forgot password..Password updating
	    userServ.updateUserPasswordByUserIdService(myUser);
	}



}
