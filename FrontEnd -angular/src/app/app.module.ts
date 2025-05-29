
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SettingsComponent } from './settings/settings.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RegisterComponent } from './register/register.component';

import { ReportComponent } from './report/report.component';
import { SettingsProfileComponent } from './settings-profile/settings-profile.component';
import { SettingsContactComponent } from './settings-contact/settings-contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { NewExamComponent } from './new-exam/new-exam.component';
import { CoursesComponent } from './courses/courses.component';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { AdminComponent } from './admin/admin.component';


import { MatCardModule} from '@angular/material/card';  
import { MatButtonModule} from '@angular/material/button';
import { QuestionsComponent } from './questions/questions.component';  
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatRadioModule} from '@angular/material/radio';
import { DemoMaterialModule } from "./material-module";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


import { MatIconModule } from '@angular/material/icon';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { LoginPopUpComponent } from './login-pop-up/login-pop-up.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { InstructionsComponent } from './instructions/instructions.component';
import { TimerComponent } from './timer/timer.component';
import {enableProdMode} from '@angular/core'; // i import it for facing error in chrome
import { CountdownModule } from 'ngx-countdown'; 
import { HttpClientModule } from '@angular/common/http';
import { DialogElementsDetailsDialogComponent } from './dialog-elements-details-dialog/dialog-elements-details-dialog.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactUsComponent,
    LoginComponent,
    PageNotFoundComponent,
    SettingsComponent,
    ForgotPasswordComponent,
    RegisterComponent,
    ReportComponent,
    SettingsProfileComponent,
    SettingsContactComponent,
    AboutUsComponent,
    NewExamComponent,
    CoursesComponent,
    AdminComponent,
    QuestionsComponent,
    NavBarComponent,
    ResetPasswordComponent,
    LoginPopUpComponent,
    AdminPanelComponent,
    InstructionsComponent,
    TimerComponent,
    DialogElementsDetailsDialogComponent,

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatCardModule,
    MatButtonModule,
    MatRadioModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatToolbarModule,
    DemoMaterialModule,
    MatIconModule,
    BrowserAnimationsModule,
    CountdownModule,
    HttpClientModule
    
   

  ],
  providers: [],
 
  bootstrap: [AppComponent]
})
export class AppModule { }
enableProdMode();