package com.example.demo.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Question;
import com.example.demo.layer3.QuestionRepositoryImpl;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	QuestionRepositoryImpl quesRepo;
	 
	@Override
	public Question findQuestionsByExamIdandLevelIdService(int examId, int levelId,int qsNo) {
		Question ques=quesRepo.findQuestionsByExamIdandLevelId(examId, levelId, qsNo);
		   return ques;
	}
	@Override
	public void addQuestionService(Question qu) {
		quesRepo.addQuestion(qu);
		
	}
	@Override
	public void removeQuestionService(int QS_NO) {
	    quesRepo.removeQuestion(QS_NO);
		
	}

}