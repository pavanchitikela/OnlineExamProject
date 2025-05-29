package com.example.demo.layer3;



import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Question;

@Repository
public interface QuestionRepository {
	Question findQuestionsByExamIdandLevelId(int examId,int levelId,int qsNo);
	 void addQuestion(Question qu);
	 void removeQuestion(int QS_NO);
	 Question getCorrectOptionByQuestionId(int myQsId);
}