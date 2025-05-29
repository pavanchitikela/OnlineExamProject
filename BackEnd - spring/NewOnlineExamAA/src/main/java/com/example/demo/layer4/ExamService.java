package com.example.demo.layer4;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Exam;
@Service
public interface ExamService {
	 void addExamService(Exam exam); 
     Exam getExamByExamIdService(int examId);
     Exam getExamByExamNameService(String examName); 
	 Set<Exam> getAllExamsService();
	 void updateExamByExamIdService(Exam exam);
	 void deleteExamByExamIdService(int examId);


}