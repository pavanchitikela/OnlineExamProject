package com.example.demo.layer4;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Exam;
import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer2.ExamResult;
import com.example.demo.layer2.ExamUser;
import com.example.demo.layer2.DTO.ExamResultDTO;
import com.example.demo.layer3.ExamRepositoryImpl;
import com.example.demo.layer3.LevelRepositoryImpl;
import com.example.demo.layer3.QuestionRepository;
import com.example.demo.layer3.ResultRepository;
import com.example.demo.layer3.UserOptionRepository;
import com.example.demo.layer3.UserRepositoryImpl;

@Service
public class ExamResultServiceImpl implements ExamResultService {
	@Autowired
	ResultRepository resultRepo;
	
	@Autowired
	UserOptionRepository userOptionRepo;
	
	@Autowired
	QuestionRepository quesRepo;
	
	 @Autowired
	 UserRepositoryImpl userRepo;
	 
	 @Autowired
	 ExamRepositoryImpl examRepo;
	 
	 @Autowired
	 LevelRepositoryImpl levelRepo;
	
	public void addResultDtoService(ExamResultDTO resultDto) {
		 ExamResult result=new ExamResult();
		 ExamUser user =userRepo.getUserByUserId(resultDto.getUserId());
		 Exam exam=examRepo.getExamByExamId(resultDto.getExamId());
		 ExamLevel level=levelRepo.getLevelByLevelId(resultDto.getLevelId());
		 
		 result.setExam(exam);
		 result.setExamLevel(level);
		 result.setExamUser(user);
		 
		 result.setCrctAns(resultDto.getCrctAns());
		 result.setIncrctAns(resultDto.getIncrctAns());
		 result.setMarks(resultDto.getMarks());
		 result.setPercentage(resultDto.getPercentage());
		 result.setStatus(resultDto.getStatus());
		 result.setCrctAns(resultDto.getCrctAns());
		resultRepo.addResult(result);
	}
	
	public List<ExamResult> getAllResultsService(){
			return resultRepo.getAllResults();
		 }
	 
	public ExamResult getResultByUserIdExamIdLevelIdService(int myUserId, int myExamId, int myLevelId) {
			return resultRepo.getResultByUserIdExamIdLevelId(myUserId, myExamId, myLevelId);
		}
			
	public List<ExamResult> getResultsByUserIdService(int userId) {
			List<ExamResult> examResult= resultRepo.getResultsByUserId(userId);
			return examResult;
	 } 
		
}
	 
