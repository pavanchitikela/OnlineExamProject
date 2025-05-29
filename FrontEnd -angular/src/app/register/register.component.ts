import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ExamUser } from './ExamUser';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private regServ: RegisterService,private router:Router) { }
  examuser: ExamUser = new ExamUser();
  isLoggedIn: boolean=false;
  loginstr!: any;
  ngOnInit(): void {
   
      this.loginstr=sessionStorage.getItem("loginInfo");
      this.isLoggedIn=JSON.parse(this.loginstr);
  }
  addUser(examuser: ExamUser){
    if(examuser.username!=null && examuser.email!=null && examuser.password!=null){
      this.regServ.addUserService(examuser).subscribe((data)=>
      {
       alert(data);
       if(data=='registration success'){
           this.router.navigate(["login"]);
        }},
        (err)=>{
          alert("some thing went wrong");
         console.log(err);
       }
      
      )
      
    }
    else{
       alert("cannot be blank...Please enter details");
  }
}
}
