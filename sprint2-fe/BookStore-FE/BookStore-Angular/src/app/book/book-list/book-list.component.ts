import {Component, OnInit} from '@angular/core';
import {BookServiceService} from '../../service/book/book-service.service';
import {Router} from '@angular/router';
import {IBook} from '../../model/book/ibook';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  // bookList: IBook[] = [];
  // page = 1;
  // size: number;
  // totalElements: number;
  //
  // constructor(private bookService: BookServiceService,
  //             private router: Router) {
  // }
  //
  // ngOnInit(): void {
  //   this.getAllTopNewBook(this.page);
  // }
  //
  // getAllTopNewBook(page: number) {
  //   this.page = page;
  //   this.bookService.getAllTopNewBook(this.page - 1).subscribe((data: any) => {
  //       this.bookList = data.content;
  //       this.size = data.size;
  //       this.totalElements = data.totalElements;
  //     },
  //     () => {
  //       this.page--;
  //       this.getAllTopNewBook(this.page);
  //     },
  //     () => {
  //     }
  //   );
  // }

  bookList: IBook[] = [];
  bookListSearch: any[] = [];
  temp: string[] = [];
  formSearch: FormGroup;
  constructor(private bookService: BookServiceService) {
  }

  ngOnInit(): void {
    this.formSearch = new FormGroup({
      categoryName: new FormControl(''),
      bookName: new FormControl(''),
      // authorName: new FormControl(''),
    });
    this.getAllBook();
    if (!localStorage.getItem('foo')) {
      localStorage.setItem('foo', 'no reload');
      location.reload();
    } else {
      localStorage.removeItem('foo');
    }
  }

  getAllBook() {
    this.bookService.getAllBook().subscribe((data: IBook[]) => {
      this.bookList = data;
      console.log(this.bookList);
    });
  }

  searchBook() {
    this.bookService.searchBook(
      this.formSearch.get('categoryName').value,
      this.formSearch.get('bookName').value,
      // this.formSearch.get('authorName').value,
    ).subscribe((data ) => {
      this.bookList = [];
      this.bookListSearch = [];
      // @ts-ignore
      this.bookList = data;
      for (let i = 0; i <= data.length; i++) {
        this.temp = data[i].split(',');
        this.bookListSearch.push(this.temp);
      }
      console.log(this.bookList);
      this.ngOnInit();
    });
  }
}
