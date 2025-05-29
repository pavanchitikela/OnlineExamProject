package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.ExamUser;




@Repository
public class UserRepositoryImpl implements UserRepository {
    
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public ExamUser getUserByUserId(int userId) {
		return entityManager.find(ExamUser.class,userId);
	}
	
	@Transactional
	public List<ExamUser> getUserByUsername(String username,String password){
		Query query=entityManager.createQuery("select q from ExamUser q where username =:myUsername and password=:myPassword",ExamUser.class);
		query.setParameter("myUsername",username);
		query.setParameter("myPassword",password);
	    @SuppressWarnings("unchecked")
	    List<ExamUser> userList=query.getResultList();
	   return userList;
	
	}

	
	@Transactional
	public void addUser(ExamUser user) {
		entityManager.persist(user);
	}

	@Transactional
	public List<ExamUser> getAllUsers() {
		String query="from ExamUser";
		List<ExamUser> userList=entityManager.createQuery(query).getResultList();
		return userList;
	}

	@Transactional
	public void deleteUserByUserId(int userId) {
		ExamUser user=entityManager.find(ExamUser.class,userId);
		entityManager.remove(user);
		}

	@Transactional // can be used for forgot password
	public void updateUserPasswordByUserId(ExamUser user) {
	    entityManager.merge(user);
		}
  
}
