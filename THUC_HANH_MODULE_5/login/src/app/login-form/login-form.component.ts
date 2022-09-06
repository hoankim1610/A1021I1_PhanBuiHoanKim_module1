import { Component, OnInit } from '@angular/core';
import {chargePassword} from "../../../../registion-form/src/app/registion/registerValidator.validator";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm : FormGroup;

  constructor() { }

    ngOnInit(): void {
      this.loginForm = new FormGroup({
        email: new FormControl('', [Validators.required, Validators.pattern('(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)')]),
        pass: new FormGroup({
          password: new FormControl('', [Validators.required, Validators.minLength(6)]),
          confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
        }, chargePassword),
        });
    }

  inputInfo() {
    this.loginForm.reset();
    console.log(this.loginForm.value);
  }

}
