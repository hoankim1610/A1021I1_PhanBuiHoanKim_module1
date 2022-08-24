import { Component, OnInit } from '@angular/core';
import {Student} from "../student";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: Student = {
    avatar: 'https://previews.123rf.com/images/nikolaydzhi/nikolaydzhi1609/nikolaydzhi160900319/64778751-muslim-girl-avatar-arab-beautiful-woman-in-green-hijab-vector.jpg',
    id: 1,
    name: 'Maria',
    address: 'Afghanistan',
    phone: 987666644,
    email: 'maria10@gmail.com'
};

  constructor() { }

  ngOnInit(): void {
  }

}
