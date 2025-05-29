package com.example.demo.layer3;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Question;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
	@PersistenceContext
	 EntityManager entityManager;
	
	@Transactional
	public Question findQuestionsByExamIdandLevelId(int myExamId,int myLevelId,int myQsNo){
		Query query=entityManager.createQuery("select q from Question q where exam_id=:examId and level_id=:levelId and qs_no=:qsNo order by qs_no",Question.class);
		query.setParameter("examId",myExamId);
		query.setParameter("levelId",myLevelId);
		query.setParameter("qsNo",myQsNo);
	    @SuppressWarnings("unchecked")
	    Question ques=(Question) query.getSingleResult();
	    return ques;
	
	}
	
	@Transactional
	public Question getCorrectOptionByQuestionId(int myQsId){
		Query query=entityManager.createQuery("select q from Question q where question_id=:qsId",Question.class);
		query.setParameter("qsId",myQsId);
		Question ques=(Question) query.getSingleResult();
	   return ques;
	}
	
	@Transactional
	public void addQuestion(Question qu) {
		entityManager.persist(qu);
	}
	@Transactional
	public void removeQuestion(int QS_NO) {
		Question question= entityManager.find(Question.class, QS_NO);
		entityManager.remove(question);
	}
}
