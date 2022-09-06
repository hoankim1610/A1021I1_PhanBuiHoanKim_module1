import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentManagementComponent } from './student-management/student-management.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentServiceComponent } from './service/student-service/student-service.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    StudentManagementComponent,
    StudentDetailComponent,
    CreateStudentComponent,
    StudentServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
