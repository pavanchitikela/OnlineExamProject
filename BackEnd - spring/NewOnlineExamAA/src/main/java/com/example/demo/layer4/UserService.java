package com.example.demo.layer4;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamUser;
import com.example.demo.layer4.Exceptions.UserAlreadyExistsException;

@Service
public interface UserService {
   ExamUser getUserByUserIdService(int userId);
   String addUserService(ExamUser user) throws UserAlreadyExistsException ; // For Registration
   List<ExamUser> getAllUsersService();
   void deleteUserByUserIdService(int userId);
   void updateUserPasswordByUserIdService(ExamUser user);
   List<ExamUser> userValdationService(String username,String password); //For Login
}
