package com.example.demo.layer3;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.ExamUser;


@Repository
public interface UserRepository {
   ExamUser getUserByUserId(int userId);
   void addUser(ExamUser user);
   List<ExamUser> getAllUsers();
   void deleteUserByUserId(int userId);
   void updateUserPasswordByUserId(ExamUser user);
   List<ExamUser> getUserByUsername(String username,String password);
}
