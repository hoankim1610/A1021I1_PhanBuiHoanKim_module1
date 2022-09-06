import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {chargePassword} from "./registerValidator.validator";

@Component({
  selector: 'app-registion',
  templateUrl: './registion.component.html',
  styleUrls: ['./registion.component.css']
})
export class RegistionComponent implements OnInit {
  registrationForm: FormGroup;

  countries: Array<string> = ['Viet Nam', 'America', 'France', 'England', "Germany"];

  constructor() { }

  ngOnInit(): void {
    this.registrationForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)')]),
      pass: new FormGroup({
        password: new FormControl('', [Validators.required, Validators.minLength(6)]),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
      }, chargePassword),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(19)]),
      gender: new FormControl('', [Validators.required]),
      // phone: new FormControl('', [Validators.required, Validators.pattern('/^\\+84\\d{9,10}$/')])
    });
  }

  addAccount() {
    this.registrationForm.reset();
    console.log(this.registrationForm.value);
  }

}
