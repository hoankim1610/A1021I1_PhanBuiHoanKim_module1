import { Component, OnInit } from '@angular/core';
import {BookServiceService} from '../../service/book/book-service.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {IBook} from '../../model/book/ibook';
import {TokenStorageService} from '../../service/security/token-storage.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  // book: IBook;
  // id: number;
  // bookListByAuthor: IBook[] = [];
  // promotionPrice: number;
  // isLoggedIn = false;
  // showHome = false;
  // userName: string;
  // roles: string[];
  // constructor(private bookService: BookServiceService,
  //             private activatedRoute: ActivatedRoute, private router: Router, private tokenStorageService: TokenStorageService) {
  //   this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
  //     this.id = +param.get('id');
  //     this.bookService.getBookById(this.id).subscribe((book) => {
  //       this.book = book;
  //       this.bookService.getAllBookSameAuthor(this.book.bookAuthorId.authorId).subscribe(data => {
  //         this.bookListByAuthor = data;
  //       });
  //     });
  //   });
  // }

  ngOnInit(): void {
    // this.promotionPrice = this.book.bookPrice - this.book.bookPrice * (this.book.bookPromotionId.promotion_percent * 0.01);
    // console.log(this.book.bookPromotionId.promotionId);
    // this.isLoggedIn = !!this.tokenStorageService.getToken();
    // if (this.isLoggedIn) {
    //   this.userName = this.tokenStorageService.getUser().account.username;
    //   this.roles = this.tokenStorageService.getUser().account.roles[0].roleName;
    //   this.showHome = this.roles.includes('ROLE_USER');
    //
    //   console.log('roles: ' + this.roles);
    // }
  }

  // getBook(id: number) {
  //   return this.bookService.getBookById(id).subscribe((book) => {
  //     this.book = book;
  //   });
  // }
  //
  // getAllBookByAuthorId(id: number) {
  //   return this.bookService.getAllBookByAuthorId(id).subscribe(data => {
  //     this.bookListByAuthor = data;
  //   });
  // }

}
