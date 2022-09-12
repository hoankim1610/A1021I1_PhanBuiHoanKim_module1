import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from "../Student/IStudent";
import {StudentServiceService} from "../service/student-service.service";
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  student: Observable<IStudent>;

  constructor(private studentService: StudentServiceService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      const id = parseInt(<string> param.get('id'));
      this.student = this.studentService.findById(id);
    })
  }


}
