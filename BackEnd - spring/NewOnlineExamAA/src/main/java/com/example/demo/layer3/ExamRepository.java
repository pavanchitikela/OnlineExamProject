
package com.example.demo.layer3;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.example.demo.layer2.Exam;
@Repository
public interface ExamRepository {
	     void addExam(Exam exam); 
	     Exam getExamByExamId(int examId);
	     Exam getExamByExamName(String examName); 
		 Set<Exam> getAllExams();
		 void updateExamByExamId(Exam exam);
		 void deleteExamByExamId(int examId);
}