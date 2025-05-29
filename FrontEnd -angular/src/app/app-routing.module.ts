import { TimerComponent } from './timer/timer.component';
import { InstructionsComponent } from './instructions/instructions.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReportComponent } from './report/report.component';
import { NewExamComponent } from './new-exam/new-exam.component';
import { QuestionsComponent } from './questions/questions.component';

import { AdminComponent } from './admin/admin.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SettingsProfileComponent } from './settings-profile/settings-profile.component';
import { SettingsComponent } from './settings/settings.component';



const routes: Routes = [
  {path:'home',component:HomeComponent,
    children:[
        {path:'report',component:ReportComponent},
    {path:'newexam', component:NewExamComponent,
      children:[
      {path:'questions',component:QuestionsComponent},
       ]
      },
    ]
  },
  {path:'navbar',component:NavBarComponent},
    
      {path:'home',component:HomeComponent},
      {path:'about',component:AboutUsComponent},
      {path:'newexam', component:NewExamComponent},
      {path:'admin', component:AdminComponent},
      {path:'login',component:LoginComponent},
      {path:'register',component:RegisterComponent},
      {path:'timer',component:TimerComponent},
      

  {path:'report',component:ReportComponent},
  {path:'login',component:LoginComponent,
      children:[
        {path:'forgot-password',component:ForgotPasswordComponent}
      ]
    },
  {path:'forgot-password',component:ForgotPasswordComponent},
  {path:'newexam', component:NewExamComponent},
  {path:'about',component:AboutUsComponent},
  
  {path:'questions',component:QuestionsComponent},
  {path:'register',component:RegisterComponent},
  {path:'admin', component:AdminComponent,
      children:[
          {path:'admin-panel',component:AdminPanelComponent}
      ]},
  {path:'timer',component:TimerComponent},
  {path:'instructions',component:InstructionsComponent},
  {path:'admin-panel',component:AdminPanelComponent},
  {path:'contactus',component:ContactUsComponent},
  {path:'signin',component:LoginComponent},
  {path:'', redirectTo:"/home",pathMatch:'full'},
  {path:'**', component:RegisterComponent},
  
 

  {path:'settings',component:SettingsComponent,
    children:[
			  {path:'profile', component:SettingsProfileComponent},
			  {path:'contact', component:SettingsProfileComponent},
			  {path:'**', component:SettingsProfileComponent},
      ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
