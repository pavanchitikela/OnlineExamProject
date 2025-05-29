package com.example.demo;

import java.sql.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Exam;
import com.example.demo.layer3.ExamRepository;

@SpringBootTest
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
			}
	}
	
	@Test
	void searchingExamByExamId() {
		Exam exam=examRepository.getExamByExamId(501);
			System.out.println(exam.getExamName());
			System.out.println(exam. getExamDate());
			System.out.println("-----------------");
	
		}
	@Test
	void searchingExamByExamName() {
		Exam exam = examRepository.getExamByExamName("java");
		System.out.println(exam.getExamId());
		System.out.println(exam. getExamDate());
		System.out.println("-----------------");
		
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
