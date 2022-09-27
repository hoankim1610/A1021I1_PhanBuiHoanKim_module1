import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {CustomerService} from "../../service/customer.service";
import {ContractService} from "../../service/contract.service";
import {DeleteContractComponent} from "../delete-contract/delete-contract.component";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  contracts: any = [];
  nameSearch: string;

  customer: any = [];
  typeSearch: string;

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private dialog : MatDialog) { }

  ngOnInit(): void {
    this.contractService.getAll().subscribe(
      (res) => {
        this.contracts = res;
      })
  }

  openDialogDelete(id: number) {
    this.contractService.findById(id).subscribe(
      (data) => {
        const dialogRef = this.dialog.open(DeleteContractComponent, {
          width: "700px",
          data: {datal : data}
        })
        dialogRef.afterClosed().subscribe(res => {
          this.ngOnInit();
        })
      })
  }

  searchByName() {
    this.contractService.findByName(this.nameSearch).subscribe((data) => {
      this.contracts = data;
    })
  }

  searchByType() {
    this.customerService.findByName(this.nameSearch).subscribe((data) => {
      this.customer = data;
    })
  }

}
