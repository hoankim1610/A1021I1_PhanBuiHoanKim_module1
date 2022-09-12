import { Component, OnInit } from '@angular/core';
import {IStudent} from "../Student/IStudent";
import {StudentInfo} from "../StudentInfo/StudentInfo";
import {StudentServiceService} from "../service/student-service.service";

@Component({
  selector: 'app-student-management',
  templateUrl: './student-management.component.html',
  styleUrls: ['./student-management.component.css']
})
export class StudentManagementComponent implements OnInit {

  studentList: IStudent[];
  // detailStudent: IStudent | undefined;

  constructor(private studentService: StudentServiceService) { }

  ngOnInit() {
    this.studentService.getAll().subscribe(
      (data: IStudent[]) => {
        this.studentList = data;
      }
    )
  }

  // changeStudent (student: IStudent) {
  //   this.detailStudent = student;
  // }
}
