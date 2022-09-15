import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customerForm: FormGroup;

  constructor(private customerService: CustomerService,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      code: new FormControl('', [Validators.required, Validators.maxLength(5), Validators.minLength(3)]),
      type: new FormControl('', [Validators.required]),
      birthday: new FormControl('', [Validators.required]),
      sex: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)')]),
      address: new FormControl('', [Validators.required]),
    });
  }

  add() {
    this.customerService.create(this.customerForm.value).subscribe(
      (res) => {
        this.router.navigateByUrl("/customer/customer-list");
        this.snackBar.open('Create successfully!', 'ok');
      }
    );
  }

}
