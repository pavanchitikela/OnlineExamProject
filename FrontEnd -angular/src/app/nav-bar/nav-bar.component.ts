import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserInfo } from '../new-exam/UserInfo';
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private router:Router) { }
  myUserInfo:UserInfo = new UserInfo(); // for user info used for login nav bar
  str:any| undefined;
  isLoggedIn: boolean | undefined ;
  loginstr!: any;
  isExamStarted!: boolean;
  ngOnInit(): void {
    //alert("login status : "+this.isLoggedIn);
    this.loginstr=sessionStorage.getItem("loginInfo");
    this.isLoggedIn=JSON.parse(this.loginstr);
    
    sessionStorage.setItem("loginInfo",JSON.stringify(this.isLoggedIn));
    this.str=sessionStorage.getItem("currentUserDetails");
    this.myUserInfo= JSON.parse(this.str);
  }
  logInCheck(){
    this.loginstr=sessionStorage.getItem("loginInfo");
    this.isLoggedIn=JSON.parse(this.loginstr);
    //alert("login status : "+this.isLoggedIn);
  }
  logOutFun(){
    if(confirm("Are you sure ?")==true){
    alert("You are logged out");
    sessionStorage.removeItem("currentUserDetails");
    this.loginstr=sessionStorage.getItem("loginInfo");
    this.isLoggedIn=JSON.parse(this.loginstr);
    this.isLoggedIn=false;
    sessionStorage.removeItem("loginInfo");
    this.router.navigate(["home"]);
    }
  }
  examStartFun(){  // not used
    this.isExamStarted=true;
  }
  profileLogo(){
    //alert("login status : "+this.isLoggedIn);
    this.loginstr=sessionStorage.getItem("loginInfo");
    this.isLoggedIn=JSON.parse(this.loginstr);
    this.isLoggedIn=true;
    sessionStorage.setItem("loginInfo",JSON.stringify(this.isLoggedIn));
    this.str=sessionStorage.getItem("currentUserDetails");
    this.myUserInfo= JSON.parse(this.str);
  }
}