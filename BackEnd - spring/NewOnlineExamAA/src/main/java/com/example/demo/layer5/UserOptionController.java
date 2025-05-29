package com.example.demo.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.DTO.UserOptionDto;
import com.example.demo.layer4.UserOptionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserOptionController {
    @Autowired
    UserOptionService userOptionServ;
    
    
    @PostMapping(path="/updateOrAddOption") 
   	public void updateOrAddOption(@RequestBody UserOptionDto userOptionDtoObj) { // Controller for user option add or update method
   		userOptionServ.updateOrAddOptionService(userOptionDtoObj.getUserId(),userOptionDtoObj.getQuestionId(),userOptionDtoObj.getUsOption() );
   	}
    }
