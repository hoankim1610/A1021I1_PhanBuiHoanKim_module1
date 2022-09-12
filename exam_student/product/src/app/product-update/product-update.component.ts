import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {CategoryServiceService} from "../service/category-service.service";
import {Category} from "../data/Category";
import {Subscription} from "rxjs";
import {Product} from "../data/Product";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  categories: any = [];
  products: Product[];

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  productForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    status: new FormControl('', [Validators.required]),
    quantity: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required])
  });

  ngOnInit(): void {
    this.getType();

    this.productService.findById(this.activatedRoute.snapshot.params.id).subscribe((data) => {
      this.productForm.setValue(data);
    })
    this.categoryService.getAllType().subscribe((data) => {
      this.categories = data;
    })
  }

  update() {
    this.productService.update(this.activatedRoute.snapshot.params.id, this.productForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("");
        this.snackBar.open("Update successfully!", "ok")
      });
  }

  getType() {
    this.categoryService.getAllType().subscribe((res) => {
      this.categories = res;
    })
  }


}
