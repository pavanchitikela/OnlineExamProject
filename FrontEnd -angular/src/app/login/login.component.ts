import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { ExamUser } from '../register/ExamUser';
import { LoginCheckService } from './login-check.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string | undefined;
  password: string | undefined;
  
  constructor(private router: Router,private loginServ:LoginCheckService,private navBarComp:NavBarComponent) { }

  ngOnInit(): void {
  }
  userFromPage: ExamUser= new ExamUser();
  currentUser: ExamUser= new ExamUser();
  isLoggedIn: boolean=false;
  userValdation(userFromPage:ExamUser){
     //alert(userFromPage.username);
     //alert(userFromPage.password);
     //alert(tempUser);
    this.loginServ.userValdationService(userFromPage).subscribe((data:any)=>{
     this.currentUser=data;
     if(this.currentUser==null)
      {
        alert('Incorrect login details'); 
        this.isLoggedIn=false;
        sessionStorage.setItem("loginInfo",JSON.stringify(this.isLoggedIn));
      
      }
      else{
        alert('login success');
        this.isLoggedIn=true;
        sessionStorage.setItem("loginInfo",JSON.stringify(this.isLoggedIn));
        this.navBarComp.logInCheck();
        sessionStorage.setItem("currentUserDetails",JSON.stringify(data));
        this.router.navigate(["home"]);
        this.navBarComp.profileLogo();
      }
      })
  }

}

