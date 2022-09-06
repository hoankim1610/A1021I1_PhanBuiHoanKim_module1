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

  constructor(private studentService: StudentServiceService) {

  }

  ngOnInit(): void {

  }

  studentList :IStudent[] = StudentInfo.getAllStudent();
  temp: IStudent = {};


  create(stu: IStudent) {
    this.studentList.push(stu);
  }

}
