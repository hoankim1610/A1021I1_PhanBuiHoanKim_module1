import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {SecurityServiceService} from '../../service/security/security-service.service';
import {TokenStorageService} from '../../service/security/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  username: string;
  password: string;
  roles: string[] = [];
  role: string;
  isLoggedIn: boolean;
  idCustomer: any;

  checkUserName: string;
  checkPassword: string;
  errorMessage: string;

  constructor(private formBuilder: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      remember_me: false
    });
    if (this.tokenStorageService.getUser()) {
      this.securityService.isLoggedIn = true;
      this.role = this.tokenStorageService.getUser().account.roles[0].roleName;
      this.username = this.tokenStorageService.getUser().account.username;
      this.router.navigate(['']);
    }
  }

  login() {
    console.log(this.loginForm.value.username)
    console.log(this.loginForm.value.password)

    this.securityService.login(this.loginForm.value).subscribe(data => {
      console.log(data);
      if (this.loginForm.value.remember_me === true) {
        this.tokenStorageService.saveUserLocal(data);
        this.tokenStorageService.saveTokenLocal(data.jwtToken);
      } else {
        this.tokenStorageService.saveUserSession(data);
        this.tokenStorageService.saveTokenSession(data.jwtToken);
      }

      this.isLoggedIn = true;
      this.username = this.tokenStorageService.getUser().account.username;
      this.role = this.tokenStorageService.getUser().account.roles[0].roleName;
      console.log('username: ' + this.tokenStorageService.getUser().account.username);
      console.log('role: ' + this.tokenStorageService.getUser().account.roles[0].roleName);
      console.log('token: ' + this.tokenStorageService.getUser().jwtToken);
      console.log('token: ' + this.tokenStorageService.getUser().account.accountId);
    }, (error) => {
      if (this.loginForm.value.username === '') {
        this.checkUserName = 'User name cannot be blank';
      } else {
        this.checkUserName = '';
      }
      if (this.loginForm.value.password === '') {
        this.checkPassword = 'Password cannot be blank';
      } else {
        this.checkPassword = '';
      }
      console.log(error);
      this.isLoggedIn = false;
      this.errorMessage = 'Username or password is not right';
    }, () => {
      this.router.navigateByUrl('/book');
      window.location.assign('http://localhost:4200');
    });
  }

  private loadRememberInfo() {
    if (this.tokenStorageService.getUser()) {
      this.role = this.tokenStorageService.getUser().account.roles[0];
      this.username = this.tokenStorageService.getUser().account.username;
    } else {
      this.role = null;
      this.username = null;
      this.idCustomer = null;
    }
    this.isLoggedIn = this.username != null;
  }

}
