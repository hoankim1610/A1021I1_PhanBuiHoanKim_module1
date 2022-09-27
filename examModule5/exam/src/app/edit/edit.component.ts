import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Instructor} from "../data/Instructor";
import {StudentService} from "../service/student.service";
import {InstructorService} from "../service/instructor.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  instructors: Instructor[];

  constructor(private studentService: StudentService,
              private instructorService: InstructorService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  studentForm: FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]*')]),
    group: new FormControl('', [Validators.required]),
    topic: new FormControl('', [Validators.required]),
    instructor: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@def\\.com(\\W|$)')]),
    phone: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(12)]),
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

  ngOnInit(): void {
    this.getType();

    this.studentService.findById(this.activatedRoute.snapshot.params.id).subscribe((data) => {
      this.studentForm.setValue(data);
    })
    this.instructorService.getAllType().subscribe((data) => {
      this.instructors = data;
    })
  }

  update() {
    this.studentService.update(this.activatedRoute.snapshot.params.id, this.studentForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("");
        this.snackBar.open("Update successfully!", "ok")
      });
  }

  getType() {
    this.instructorService.getAllType().subscribe((res) => {
      this.instructors = res;
    })
  }

}
