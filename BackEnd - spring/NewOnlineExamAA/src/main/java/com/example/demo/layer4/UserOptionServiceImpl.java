package com.example.demo.layer4;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.ExamUser;
import com.example.demo.layer2.Question;
import com.example.demo.layer2.UserOption;
import com.example.demo.layer3.UserOptionRepository;
@Service
public class UserOptionServiceImpl implements UserOptionService {
@Autowired
        UserOptionRepository userOptionRepo;
        
@Override
    public void addUserOptionService(UserOption userOption ) {
        userOptionRepo.addUserOption(userOption);
        }
@Override
 public List<UserOption> getUserOptionByUserIdandQuestionNumberService(int userId,int qsNo) {
     List<UserOption>userOptionList=userOptionRepo.getUserOptionByUserIdandQuestionNumber(userId,qsNo);
     return userOptionList;
        }


//Business Method
@Override
public void updateOrAddOptionService(int userId, int questionId, String newOption) { //user option add or update method
	List<UserOption> userOptionList=userOptionRepo.getUserOptionByUserIdandQuestionNumber(userId,questionId);
	System.out.println("User Options"+userOptionList);
	if(userOptionList.isEmpty()) {
		UserOption userOptObj=new UserOption();
		ExamUser user=new ExamUser();
		Question question=new Question();
		user.setUserId(userId);
		question.setQuestionId(questionId);
		userOptObj.setExamUser(user);
		userOptObj.setQuestion(question);
		userOptObj.setUsOption(newOption);
		userOptionRepo.addUserOption(userOptObj);
		}
	else {
		for(UserOption userOption:userOptionList) {
		userOptionRepo.updateUsOptionByUoId(newOption, userOption.getUserOptionId());
		}
	}
	}
}