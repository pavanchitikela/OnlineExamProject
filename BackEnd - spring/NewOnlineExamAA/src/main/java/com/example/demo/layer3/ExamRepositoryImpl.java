package com.example.demo.layer3;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Exam;
@Repository
public class ExamRepositoryImpl implements ExamRepository {//isA
		@PersistenceContext
		 EntityManager entityManager;
		
		
		@Transactional
		public void addExam(Exam exam) {
			entityManager.persist(exam);

		}
		@Transactional
		public Exam getExamByExamId(int examId) {
			System.out.println("onlineexam repo....NO scope of bussiness logic here...");
			return entityManager.find(Exam.class,examId);
			
		}

		@Transactional
		public Exam getExamByExamName(String examName) {
				Query query = entityManager.createQuery("select e from Exam e where exam_name =:myExam",Exam.class).setParameter("myExam", examName);
				Exam exam = (Exam) query.getSingleResult();
			    return exam;
		}

		@Transactional
		public Set<Exam> getAllExams() {
			Set<Exam> ExSet;
			ExSet= new HashSet<Exam>();
			String queryString = "from Exam";
			Query query = entityManager.createQuery(queryString);
			ExSet = new HashSet(query.getResultList());
			return ExSet;
		}	
		
		@Transactional
		public void updateExamByExamId(Exam exam) {
			entityManager.merge(exam);
		}

		@Transactional
		public void deleteExamByExamId(int examId) {
			Exam ex = entityManager.find(Exam.class,examId);
			entityManager.remove(ex);
			
		}

	}
