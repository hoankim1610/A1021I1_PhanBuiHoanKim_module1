import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StudentServiceService} from "../service/student-service.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {


  studentForm: FormGroup;

  constructor(private studentService: StudentServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.studentForm = new FormGroup({
      avatar: new FormControl(),
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      mark: new FormControl('', [Validators.required])
    })
  }

  submit() {
    const student = this.studentForm.value;
    this.studentService.save(student);
    this.router.navigateByUrl("");
  }

  // addStudent() {
  //   this.studentService.addStudent(this.studentForm.value);
  //   this.router.navigateByUrl("");
  // }

// @Output() showCreate = new EventEmitter();
//
//   constructor() {}
//
//
//   ngOnInit(): void {
//   }
//
//   addStudent(avatar: string, id: string, name: string, address: string, phone: string, email: string, mark: string) {
//       const stu: IStudent = {avatar, id: parseInt(id), name, address, phone: parseInt(phone), email, mark: parseInt(mark)
//       };
//       this.showCreate.emit(stu);
//   }

}
