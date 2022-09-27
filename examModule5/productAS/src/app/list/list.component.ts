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

  deleteTemp: Product = {
    category: {}
  }

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      (res) => {
        this.products = res;
      })
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

}
