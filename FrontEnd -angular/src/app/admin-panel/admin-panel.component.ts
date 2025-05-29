import { Component, OnInit } from '@angular/core';
import { ExamResult } from './ExamResult';
import { ViewUsersService } from './view-users.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {
  displayedColumns: string[] = ['userId', 'username', 'email','mobile' ,'city' ,'qual' ,'state' ,'yoc'];
  constructor(private user:ViewUsersService,private result:ViewUsersService) { }

  ngOnInit(): void {
  }
  tempUser:Array<any>=[];
  getAllUsers(){
    
    this.user.getAllUsersService().subscribe((data)=>{
      if (data!=null) 
      {
        this.tempUser=data;
        console.log(this.tempUser);
        sessionStorage.setItem("UserDetails",JSON.stringify(data)); 
      }
      else{
        alert('unable to fetch');
        
       }
       })
      }

      tempResultAry:ExamResult[]=[];

  getAllResults(){
    this.result.getAllResultsService().subscribe((data)=>{
      if(data!=null){
           this.tempResultAry=data;
           //sessionStorage.setItem("resultAllDetails",JSON.stringify(data)); // storing this on browser session
       }
       else{
           alert("unable to fetch");
       }})
     }

}
