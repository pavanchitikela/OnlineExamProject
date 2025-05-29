import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
username : string | undefined;
password : string | undefined; 
 
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  login() : void {
    if(this.username == 'pavan' && this.password == 'pavan'){
     this.router.navigate(["admin-panel"]);
    }else {
      alert("Invalid credentials");
    }
  }

}
