package com.example.demo.layer3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.ExamUser;
import com.example.demo.layer2.UserOption;
@Repository
public class UserOptionRepositoryImpl implements UserOptionRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
     public void addUserOption(UserOption userOption) {
        entityManager.persist(userOption);
    }

    @Transactional
    public List<UserOption> getUserOptionByUserIdandQuestionNumber(int userId, int qsId) {
        Query query=entityManager.createQuery("select u from UserOption u where user_Id=:myUserId and question_id=:myQsId",UserOption.class);
        query.setParameter("myUserId",userId);
        query.setParameter("myQsId",qsId);
         @SuppressWarnings("unchecked")
        List<UserOption> usOptionList=query.getResultList();
        return usOptionList;
    }

	@Transactional
	public void updateUsOptionByUoId(String userOption,int userOptionId) {
		Query query=entityManager.createQuery("UPDATE from UserOption u SET u.usOption=:usOption where userOptionId=:userOptionId");
		query.setParameter("userOptionId",userOptionId);
		query.setParameter("usOption",userOption);
		query.executeUpdate();
	}
}
