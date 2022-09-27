import { Component, OnInit } from '@angular/core';
import {Customer} from "../../data/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CustomerService} from "../../service/customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  customers : Customer[];

  constructor(private customerService: CustomerService,
              private router: Router,
              private active: ActivatedRoute,
              private snackBar : MatSnackBar) {
  }

  customerForm = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    code: new FormControl('', [Validators.required, Validators.maxLength(5)]),
    type: new FormControl('', [Validators.required]),
    birthday: new FormControl('', [Validators.required]),
    sex: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)')]),
    address: new FormControl('', [Validators.required]),
  });

  ngOnInit(): void {
    this.customerService.findById(this.active.snapshot.params.id).subscribe(
      (data) => {
        this.customerForm.setValue(data);
      })
    this.customerService.getAll().subscribe((res) => {
      this.customers = res;
    })
  }

  editNew() {
    this.customerService.update(this.active.snapshot.params.id, this.customerForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("/customer/customer-list");
        this.snackBar.open("Update succesfully!", "ok")
      });
  }

}
