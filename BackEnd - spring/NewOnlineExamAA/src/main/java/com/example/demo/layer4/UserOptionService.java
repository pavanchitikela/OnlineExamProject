package com.example.demo.layer4;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.layer2.UserOption;
@Service
public interface UserOptionService {
     void addUserOptionService(UserOption userOption );
     List<UserOption> getUserOptionByUserIdandQuestionNumberService(int userId,int qsNo);
     void updateOrAddOptionService(int userId,int qsNo,String userOption) ;
}
