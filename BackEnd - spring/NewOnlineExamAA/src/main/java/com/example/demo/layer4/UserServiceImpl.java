package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamUser;
import com.example.demo.layer3.UserRepositoryImpl;
import com.example.demo.layer4.Exceptions.UserAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {
	
	   @Autowired
	   UserRepositoryImpl userRepo;
	
	 
	   public ExamUser getUserByUserIdService(int userId) {
		  ExamUser eu=userRepo.getUserByUserId(userId);
		  return eu;
	    }
	   
	   public String addUserService(ExamUser eu) throws UserAlreadyExistsException {  //For Registration
		   System.out.println("ExamUser Service....Some scope of bussiness logic here...");
		   try {
		   userRepo.addUser(eu);
		   }catch (Exception e) {
				throw new UserAlreadyExistsException("User already exists");
			}
			return "User added successfully";
		}
	   public List<ExamUser> getAllUsersService() {
		   List<ExamUser> userList=userRepo.getAllUsers();
			return userList;
		}
	   public void deleteUserByUserIdService(int userId) {
		   userRepo.deleteUserByUserId(userId);
		}
	   public void updateUserPasswordByUserIdService(ExamUser eu) {
		   userRepo.updateUserPasswordByUserId(eu);
		}
	   
	   public List<ExamUser> userValdationService(String username, String password) { // user login check
		   List<ExamUser>  userList= userRepo.getUserByUsername(username,password);
			return userList;
		}
	   
}
