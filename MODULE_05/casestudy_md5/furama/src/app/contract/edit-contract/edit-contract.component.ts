import { Component, OnInit } from '@angular/core';
import {Contract} from "../../data/contract";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CustomerService} from "../../service/customer.service";
import {ContractService} from "../../service/contract.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-contract',
  templateUrl: './edit-contract.component.html',
  styleUrls: ['./edit-contract.component.css']
})
export class EditContractComponent implements OnInit {

  customers: any = [];
  contracts: Contract[];

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  contractForm = new FormGroup({
    id: new FormControl(''),
    customer: new FormControl('', [Validators.required]),
    start: new FormControl('', [Validators.required]),
    end: new FormControl('', [Validators.required]),
    deposit: new FormControl('', [Validators.required]),
    total: new FormControl('', [Validators.required])
  });

  ngOnInit(): void {
    this.getType();

    this.contractService.findById(this.activatedRoute.snapshot.params.id).subscribe((data) => {
      this.contractForm.setValue(data);
    })
    this.customerService.getAll().subscribe((data) => {
      this.customers = data;
    })
  }

  update() {
    this.contractService.update(this.activatedRoute.snapshot.params.id, this.contractForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("contracts/contract-list");
        this.snackBar.open("Update successfully!", "ok")
      });
  }

  getType() {
    this.customerService.getAll().subscribe((res) => {
      this.customers = res;
    })
  }


}
