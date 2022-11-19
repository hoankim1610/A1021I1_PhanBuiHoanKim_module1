import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../service/security/token-storage.service';
import {Router} from '@angular/router';
import {CategoryServiceService} from '../service/book/category-service.service';
import {ICategory} from '../model/book/icategory';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  private roles: string[];
  categoryList: ICategory[] = [];
  isLoggedIn = false;
  showHome = false;
  userName: string;
  search: string;
  constructor(private tokenStorageService: TokenStorageService,
              private router: Router,  private categoryService: CategoryServiceService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      this.userName = this.tokenStorageService.getUser().account.username;
      this.roles = this.tokenStorageService.getUser().account.roles[0].roleName;
      this.showHome = this.roles.includes('ROLE_USER');
      console.log('roles: ' + this.roles);
    }
    this.getAllCategory();
    // this.search = (<HTMLInputElement>document.getElementById("username")).value;
  }
  logout() {
    this.tokenStorageService.signOut();
    window.location.assign('');
    this.router.navigateByUrl('');
  }

  getAllCategory() {
    return this.categoryService.getAllCategory().subscribe(data => {
      this.categoryList = data;
    });
  }

  searchBook(value: string) {
    this.router.navigateByUrl('/search/' + value);
  }
}
