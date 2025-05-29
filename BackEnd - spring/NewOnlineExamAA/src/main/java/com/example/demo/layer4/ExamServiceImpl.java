package com.example.demo.layer4;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.Exam;
import com.example.demo.layer3.ExamRepositoryImpl;

@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	 ExamRepositoryImpl examRepo;
	 public void addExamService(Exam exam) {
		   examRepo.addExam(exam);
		}
	 public Exam getExamByExamIdService(int examId) {
		  Exam ex=examRepo.getExamByExamId(examId);
		  return ex;
	    }
	 public Exam getExamByExamNameService(String examName) {
		 Exam exam=examRepo.getExamByExamName(examName);
		  return exam;
	    }
	 public Set<Exam> getAllExamsService() {
		   Set<Exam> examSet=examRepo.getAllExams();
			return examSet;
		}
	 public void updateExamByExamIdService(Exam exam) {
		   examRepo.updateExamByExamId(exam);
		}
	 public void deleteExamByExamIdService(int examId) {
		   examRepo.deleteExamByExamId(examId);
		}
	

}