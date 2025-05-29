package com.example.demo.layer3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer2.ExamUser;

@Repository
public class LevelRepositoryImpl implements LevelRepository {

	@PersistenceContext
	 EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ExamLevel> findlevels() {
		List<ExamLevel> lList;
		lList = new ArrayList<ExamLevel>();
		
			String queryString = "from ExamLevel";
			Query query = entityManager.createQuery(queryString);
			lList = query.getResultList();
		return lList;
		
		
	}
	@Transactional
	public void modifyExamLevelByLevel_Id(ExamLevel el) {
		entityManager.merge(el);
	}
	@Override
	public ExamLevel getLevelByLevelId(int LevelId) {
		return entityManager.find(ExamLevel.class,LevelId);
	}
}