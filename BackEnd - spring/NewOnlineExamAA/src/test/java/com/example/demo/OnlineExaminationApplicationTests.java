package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.layer2.Exam;
import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer2.ExamResult;
import com.example.demo.layer2.ExamUser;
import com.example.demo.layer2.Question;
import com.example.demo.layer2.UserOption;
import com.example.demo.layer3.ExamRepository;
import com.example.demo.layer3.QuestionRepository;
import com.example.demo.layer3.ResultRepository;
import com.example.demo.layer3.UserOptionRepository;
import com.example.demo.layer3.UserRepository;

import java.sql.Date;
import java.util.List;
import java.util.Set;
@SpringBootTest
class OnlineExaminationApplicationTests {
	public class ExamTesting {
		@Autowired
		ExamRepository examRepository;
		@Test
		void addingExam() {
			Exam exam=new Exam();
			exam.setExamId(508);
			exam.setExamName("R");
			String str="2021-04-20";
			Date date=Date.valueOf(str);
		    exam.setExamDate(date);
		    examRepository.addExam(exam);
		    System.out.println("-----------------");
		    
			}
		@Test
		void findingAllExams() {
			Set<Exam> examSet=examRepository.getAllExams();
			for (Exam exam: examSet) {
				System.out.println(exam.getExamId());
				System.out.println(exam.getExamName());
				System.out.println(exam. getExamDate());
				System.out.println("-----------------");
				/*
				int examId=506;
			    String examName="SQL";
			    assertEquals("SQL",examName);
				System.out.println("such exam was existed");
				assertNotNull(examName);
				System.out.println("examName is not null");
				assertTrue(examId>700);
				System.out.println("examId passed");
				System.out.println("testing exam assertion is over");
				System.out.println("-----------------");*/
				}
		}
		
		@Test
		void searchingExamByExamId() {
			Exam exam=examRepository.getExamByExamId(501);
				System.out.println(exam.getExamName());
				System.out.println(exam. getExamDate());
				System.out.println("-----------------");
				/*
				int examId=506;
			    String examName="SQL";
			    assertEquals("SQL",examName);
				System.out.println("such exam was existed");
				assertNotNull(examName);
				System.out.println("examName is not null");
				assertTrue(examId<700);
				System.out.println("examId passed");
				System.out.println("testing exam assertion is over");
				System.out.println("-----------------");*/
			}
		@Test
		void searchingExamByExamName() {
			Exam exam = examRepository.getExamByExamName("java");
			
				System.out.println(exam.getExamId());
				System.out.println(exam. getExamDate());
				System.out.println("-----------------");
				/*
				int examId=506;
			    String examName="SQL";
			    assertEquals("sql",examName);
				System.out.println("such exam was existed");
				assertNotNull(examName);
				System.out.println("examName is not null");
				assertTrue(examId<700);
				System.out.println("examId passed");
				System.out.println("testing exam assertion is over");
				System.out.println("-----------------");*/
			
		}
		
		@Test
		void updatingExamByExamId() {
			Exam exam=new Exam();
			exam.setExamId(508);
			exam.setExamName("cpp");
			String str="2021-04-25";
			Date date=Date.valueOf(str);
		    exam.setExamDate(date);
		    examRepository.updateExamByExamId(exam);
		    System.out.println("-----------------");
			}
		
		@Test
		public void deletingExamByExamId() {
			examRepository.deleteExamByExamId(508);
			System.out.println("-----------------");
		}
	}
	@Autowired
	ResultRepository resultRepo;
	
	@Autowired
	UserRepository euRepo;
	
	@Autowired
	UserOptionRepository userOptionRepo;
	
	@Autowired
	QuestionRepository quesRepo;
	@Test
	void getUser() {
		ExamUser eu=euRepo.getUserByUserId(101);
		System.out.println(eu.getUsername());
		System.out.println(eu.getCity());
		System.out.println(eu.getMobile());
	}
	@Test
	void addUser() {
		ExamUser eu=new ExamUser();
		eu.setUsername("hemanth");
		eu.setCity("Hyderabad");
		eu.setState("Telangana");
		eu.setEmail("hemanth123@gmail.com");
		eu.setMobile(856932621);
		String str="1995-02-23";
		Date date=Date.valueOf(str);
		eu.setDob(date);
		eu.setQual("BE");
		eu.setYoc(2019);
		eu.setPassword("dsdfdsfe");
		euRepo.addUser(eu);;
	}
	
	@Test
	void getAllUsers() {
		List<ExamUser> euList=euRepo.getAllUsers();
		for(ExamUser eu: euList) {
			System.out.println(eu.getUsername());
			System.out.println(eu.getCity());
			System.out.println(eu.getMobile());
			System.out.println(eu.getState());
			System.out.println(eu.getEmail());
			System.out.println(eu.getQual());
			System.out.println(eu.getYoc());
			System.out.println(eu.getDob());
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	void deleteUser() {
		euRepo.deleteUserByUserId(0);
	}
	@Test
	void updateUserPassword(){
		ExamUser eu=euRepo.getUserByUserId(104);
		eu.setPassword("vishnu145");
		euRepo.updateUserPasswordByUserId(eu);
	}
	
	//Result Repo Test
	@Test
	void addResult() {
		ExamResult result=new ExamResult();
		ExamUser examuser=new ExamUser();
		Exam exam=new Exam();
		ExamLevel level=new ExamLevel();
		result.setResultId(33059);
		result.setCrctAns(9);
		result.setIncrctAns(0);
		result.setMarks(9);
		result.setPercentage(80.0f);
		result.setStatus("pass");
		examuser.setUserId(103);
		exam.setExamId(504);
		level.setLevelId(3);
		result.setExamUser(examuser);
		result.setExam(exam);
		result.setExamLevel(level);
		resultRepo.addResult(result) ;
	}
	@Test
	void getAllResults() {
		List<ExamResult> rList=resultRepo.getAllResults();
		for (ExamResult r :rList) {
			ExamUser eu=r.getExamUser();
			Exam ex=r.getExam();
			ExamLevel lv=r.getExamLevel();
			System.out.println(r.getResultId());
			System.out.println(eu.getUserId());
			System.out.println(ex.getExamId());
			System.out.println(lv.getLevelId());
			System.out.println(r.getCrctAns());
			System.out.println(r.getIncrctAns());
			System.out.println(r.getMarks());
			System.out.println(r.getPercentage());
			System.out.println(r.getStatus());
			}
		}
	
	@Test
	void getResultByUserIdExamIdLevelId() {
		ExamResult r=resultRepo.getResultByUserIdExamIdLevelId(101,501,1);
		System.out.println(r.getResultId());
	}
	
	@Test
	void getResultsByUserId() {
		List<ExamResult> resultList=resultRepo.getResultsByUserId(101);
		for (ExamResult res :resultList) {
		Exam exam=res.getExam();
		ExamLevel examLevel=res.getExamLevel();
		System.out.println(res.getResultId());
		System.out.println(exam.getExamId());
		System.out.println(examLevel.getLevelId());
		System.out.println(res.getCrctAns());
		System.out.println(res.getIncrctAns());
		System.out.println(res.getMarks());
		System.out.println(res.getPercentage());
		System.out.println(res.getStatus());
	}
	}
	
	@Test
	void addUserOption() {
		UserOption userOption=new UserOption();
		ExamUser examUser=new ExamUser();
		Question question=new Question();
		examUser.setUserId(103);
		question.setQsNo(15);
		userOption.setExamUser(examUser);
		userOption.setQuestion(question);
		userOption.setUsOption("delete");
		userOptionRepo.addUserOption(userOption);
	}
	

	@Test
	void updateOrAddOption() { // Updates the user option of existing userId, if userId not exists than it will add a new row
		int userId=102;
		int qsNo=4;
		String newOption="Class";
		List<UserOption> userOptionList=userOptionRepo.getUserOptionByUserIdandQuestionNumber(userId,qsNo);
		System.out.println("User Options"+userOptionList);
		if(userOptionList.isEmpty()) {
			UserOption userOptObj=new UserOption();
			ExamUser user=new ExamUser();
			Question question=new Question();
			user.setUserId(userId);
			question.setQsNo(qsNo);
			userOptObj.setExamUser(user);
			userOptObj.setQuestion(question);
			userOptObj.setUsOption(newOption);
			userOptionRepo.addUserOption(userOptObj);
			}
		else {
			for(UserOption userOption:userOptionList) {
			userOptionRepo.updateUsOptionByUoId(newOption,userOption.getUserOptionId());
				}
	}
	}
	
	@Test
	void AnswerCheck(){
		int userId=101;
		int examId=503;
		int levelId=1;
		int questionId=61;
		int correctAnswers=0;
		int inCorrectAnswers=0;
		int percentage;
		int marks=0;
		String status=null;
		Question ques=quesRepo.getCorrectOptionByQuestionId(questionId);
		List<UserOption> userOptList= userOptionRepo.getUserOptionByUserIdandQuestionNumber(userId, questionId);
		
		String correctOption=ques.getCrctOpt();
		System.out.println("CorrectOption"+ques.getCrctOpt());
		for(UserOption userOpt:userOptList) {
		    System.out.println("UserOption"+userOpt.getUsOption());
		    String userSelectedOption=userOpt.getUsOption();
		    if(userSelectedOption.equalsIgnoreCase(correctOption)) {
		    	correctAnswers=correctAnswers+1;
		    	marks=marks+1;
		    	percentage=marks*10;
		    	//System.out.println("marks :"+);
		    }
		    else {
		    	inCorrectAnswers=inCorrectAnswers+1;
		    }
		}
		if(questionId%10==0) {
			ExamResult result=new ExamResult();
			ExamUser exUser=new ExamUser();
			Exam exam=new Exam();
			ExamLevel level=new ExamLevel();
			
			exUser.setUserId(userId);
			exam.setExamId(examId);
			level.setLevelId(levelId);
			result.setExamUser(exUser);
			result.setExam(exam);
			result.setExamLevel(level);
			result.setMarks(marks);
			if(marks>6) {
				status="pass";
			}
			else {
				status="fail";
			}
			result.setStatus(status);
			resultRepo.addResult(result);
			System.out.println("added successfully..");
		}
	}

}
