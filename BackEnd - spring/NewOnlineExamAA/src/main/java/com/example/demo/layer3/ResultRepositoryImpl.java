package com.example.demo.layer3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.layer2.ExamResult;
@Repository
public class ResultRepositoryImpl implements ResultRepository {
	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	public void addResult(ExamResult result) {
		entityManager.persist(result);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ExamResult> getAllResults() {
		List<ExamResult>resultList;
		resultList = new ArrayList<ExamResult>();
		String queryString = "from ExamResult";
		Query query = entityManager.createQuery(queryString);
		resultList = query.getResultList();
		return resultList;
		}
	
	@Transactional
	public ExamResult getResultByUserIdExamIdLevelId(int myUserId, int myExamId, int myLevelId) { // for levelwise result....
		Query query=entityManager.createQuery("select max(r.resultId) from ExamResult r where user_id=:UserId and exam_id=:ExamId and level_id=:LevelId)",ExamResult.class);
		query.setParameter("UserId",myUserId);
		query.setParameter("ExamId",myExamId);
		query.setParameter("LevelId",myLevelId);
		@SuppressWarnings("unchecked")
		ExamResult  result=(ExamResult) query.getSingleResult();
		return result;
	}
	
	@Transactional
	public List<ExamResult> getResultsByUserId(int userId){
		Query query=entityManager.createQuery("select r from ExamResult r where user_id=:UserId");
		query.setParameter("UserId",userId);
		@SuppressWarnings("unchecked")
		List<ExamResult>resultList=query.getResultList();
		return resultList;
	}
	
}
