import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from "../Student/IStudent";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input() stu : IStudent = {
  }

  constructor() { }

  ngOnInit(): void {
  }

  changeMark(target): void {
    this.stu.mark = target;
  }

}
