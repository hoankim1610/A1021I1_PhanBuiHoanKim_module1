import {Component, OnInit} from '@angular/core';
import {Product} from "../data/Product";
import {Category} from "../data/Category";
import {ProductServiceService} from "../service/product-service.service";
import {CategoryServiceService} from "../service/category-service.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {throwUnknownPortalTypeError} from "@angular/cdk/portal/portal-errors";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  products: Product[] = [];
  categories: Category[] = [];

  deleteTemp: Product = {
    category: {}
  }

  totalPageList: number[] = [];

  page: number = 0;
  size: number;
  totalPages: number;

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (res) => {
        this.products = res;
      });
    // this.get();
  }

  showDelete(products: Product) {
    this.deleteTemp = products;
  }

  delete(id: number) {
    this.productService.delete(id).subscribe(
      (res) => {
        this.snackBar.open("Delete successfully!", "ok");
      },
      () => {
      },
      () => {
        this.ngOnInit();
      });
  }



  // Pagination
  get() {
    this.productService.getAllPage(this.page, this.size).subscribe((data: any) => {
        this.products = data.content;

        this.totalPageList = [];
        this.totalPages = data.totalPages;

        for (let i = 0; i < this.totalPages; i++) {
          this.totalPageList.push(i);
        }
        console.log(this.page)
        console.log(this.totalPages)
      },
      () => {
        this.page--;
        this.get();
      });

    this.categoryService.getAllType().subscribe((data) => {
      this.categories = data;
    });
  }

  getPreviousPage() {
    this.page--;
  }

  getNextPage() {
    this.page++;
  }

  getNumberPage(pageNumber: number) {
    this.page = pageNumber;
  }
  // Pagination


}
