import { Injectable } from '@angular/core';
import {StudentInfo} from "../StudentInfo/StudentInfo";

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  constructor() { }

  getAll() {
    return StudentInfo.studentList;
  }
}
