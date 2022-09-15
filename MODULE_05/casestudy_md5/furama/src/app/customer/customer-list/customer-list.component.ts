import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: any = [];

  nameSearch: any;

  constructor(private customerService: CustomerService,
              private dialog : MatDialog) {
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(
      (res) => {
        this.customers = res;
      })
  }

  openDialogDelete(id: number) {
    this.customerService.findById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(DeleteCustomerComponent, {
          width: "700px",
          data: {datal : data}
        })
        dialogRef.afterClosed().subscribe(res => {
          this.ngOnInit();
        })
      })
  }

  searchByName() {
    this.customerService.findByName(this.nameSearch).subscribe((data) => {
      this.customers = data;
    })
  }

}
