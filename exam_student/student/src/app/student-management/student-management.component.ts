import { Component, OnInit } from '@angular/core';

export interface Student {
  avatar?: string,
  id?: number,
  name?: string,
  address?: string,
  phone?: number,
  email?: string
}

@Component({
  selector: 'app-student-management',
  templateUrl: './student-management.component.html',
  styleUrls: ['./student-management.component.css']
})
export class StudentManagementComponent implements OnInit {
  student: Student[] = [{
    avatar: 'https://previews.123rf.com/images/nikolaydzhi/nikolaydzhi1609/nikolaydzhi160900319/64778751-muslim-girl-avatar-arab-beautiful-woman-in-green-hijab-vector.jpg',
    id: 1,
    name: 'Maria',
    address: 'Afghanistan',
    phone: 987666644,
    email: 'maria10@gmail.com'
  },
  {
    avatar: 'https://thumbs.dreamstime.com/z/girl-lovely-avatar-blonde-hair-cartoon-icon-stock-vector-93364827.jpg',
    id: 2,
    name: 'Lucia',
    address: 'America',
    phone: 975646473,
    email: 'lucia11@gmail.com'
  }];


  constructor() {

  }

  ngOnInit(): void {
  }

}
