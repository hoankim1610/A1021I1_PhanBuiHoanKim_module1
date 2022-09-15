import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ContractService} from "../../service/contract.service";
import {Customer} from "../../data/customer";
import {Contract} from "../../data/contract";

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {

  contractForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required]),
    customer: new FormControl('', [Validators.required]),
    start: new FormControl('', [Validators.required]),
    end: new FormControl('', [Validators.required]),
    deposit: new FormControl('', [Validators.required]),
    total: new FormControl('', [Validators.required]),
  });

  customers: Customer[];

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private router: Router,
              private snackBar : MatSnackBar) {
  }
  ngOnInit(): void {
    this.getType();
  }

  add() {
    const contract: Contract = {
      id: this.contractForm.value.name,
      customer: {
        id: this.contractForm.value.customer
      },
      startDay: this.contractForm.value.startDay,
      endDay: this.contractForm.value.endDay,
      deposit: this.contractForm.value.deposit,
      total: this.contractForm.value.total
    };
    this.contractService.create(this.contractForm.value).subscribe((res) => {
      this.router.navigateByUrl("/contracts/contract-list");
      this.snackBar.open("Create successfully!", "ok");
    })
  }

  getType() {
    this.customerService.getAll().subscribe((res) => {
        this.customers = res;
      }
    )
  }


}
