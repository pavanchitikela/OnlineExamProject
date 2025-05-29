package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.layer2.UserOption;

@Repository
public interface UserOptionRepository {
	 void addUserOption(UserOption userOption );
	 List<UserOption> getUserOptionByUserIdandQuestionNumber(int userId, int qsId);
	 void updateUsOptionByUoId(String userOption,int userOptionId);
	 
}
