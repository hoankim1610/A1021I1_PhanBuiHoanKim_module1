import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Instructor} from "../data/Instructor";
import {StudentService} from "../service/student.service";
import {InstructorService} from "../service/instructor.service";
import {Student} from "../data/Student";


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  studentForm: FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]*')]),
    group: new FormControl('', [Validators.required]),
    topic: new FormControl('', [Validators.required]),
    instructor: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@def\\.com(\\W|$)')]),
    phone: new FormControl('', [Validators.required]),
  });

  get name() {
    return this.studentForm.get('name');
  }

  get group() {
    return this.studentForm.get('group');
  }

  get topic() {
    return this.studentForm.get('topic');
  }

  get email() {
    return this.studentForm.get('email');
  }

  get phone() {
    return this.studentForm.get('phone');
  }

  instructor: Instructor[];

  constructor(private studentService: StudentService,
              private instructorService: InstructorService,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getType();
  }

  add() {
    const students: Student = {
      id: this.studentForm.value.id,
      name: this.studentForm.value.name,
      group: this.studentForm.value.group,
      instructor: {
        id: this.studentForm.value.instructor
      },
      email: this.studentForm.value.email,
      phone: this.studentForm.value.phone
    };
    this.studentService.create(this.studentForm.value).subscribe((res) => {
      this.router.navigateByUrl("");
      this.snackBar.open("Create successfully!", "ok");
    })
  }

  getType() {
    this.instructorService.getAllType().subscribe((res) => {
        this.instructor = res;
      }
    )
  }
}
