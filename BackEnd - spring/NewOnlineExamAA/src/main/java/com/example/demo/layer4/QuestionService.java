package com.example.demo.layer4;


import org.springframework.stereotype.Service;
import com.example.demo.layer2.Question;

@Service
public interface QuestionService {
	Question findQuestionsByExamIdandLevelIdService(int ExamId,int LevelId,int qsNo);
	void addQuestionService(Question qu);
	void removeQuestionService(int QS_NO);
}
