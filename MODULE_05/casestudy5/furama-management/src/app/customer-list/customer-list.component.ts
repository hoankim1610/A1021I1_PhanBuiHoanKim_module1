import { Component, OnInit } from '@angular/core';

export interface Customer {
  avatar?: string;
  id?: number;
  name?: string;
  code?: string;
  type?: string;
  birthday?: string;
  sex?: string;
  idCard?: number;
  phone?: string;
  email?: string;
  address?: string
}

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customer: Customer[] = [{
    avatar: 'https://png.pngtree.com/png-clipart/20210308/original/pngtree-foreign-people-hand-drawn-avatar-female-png-image_5748377.jpg',
    id: 1,
    name: 'Masha',
    code: 'Vip_1',
    type: 'VIP',
    birthday: '27/02/1990',
    sex: 'Female',
    idCard: 123456,
    phone: '0987 455 332',
    email: 'masha22@gmail.com',
    address: '27L/90H Lorna California America'
  },
    {
      avatar: 'https://png.pngtree.com/png-clipart/20190905/original/pngtree-cartoon-man-avatar-free-illustration-png-image_4535815.jpg',
      id: 2,
      name: 'Otis',
      code: 'Inter_3',
      type: 'Inter',
      birthday: '19/05/1985',
      sex: 'Male',
      idCard: 345555,
      phone: '0966 555 433',
      email: 'Ota33@gmail.com',
      address: '987B Hocksae Temani Afghanistan'
    }];

  constructor() { }

  ngOnInit(): void {
  }

}
