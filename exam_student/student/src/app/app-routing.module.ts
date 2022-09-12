import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {patchCallbacks} from "zone.js/lib/browser/browser-util";
import {StudentManagementComponent} from "./student-management/student-management.component";
import {StudentDetailComponent} from "./student-detail/student-detail.component";
import {CreateStudentComponent} from "./create-student/create-student.component";


const routes: Routes = [
  {path: '', component: StudentManagementComponent},
  {path: 'create', component: CreateStudentComponent},
  {path: 'detail/:id', component: StudentDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
