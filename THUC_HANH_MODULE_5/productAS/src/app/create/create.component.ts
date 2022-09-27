import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {CategoryServiceService} from "../service/category-service.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Category} from "../data/Category";
import {Product} from "../data/Product";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  productForm: FormGroup = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]*')]),
      price: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
    }
  );

  get name() {
    return this.productForm.get('name');
  }

  get price() {
    return this.productForm.get('price');
  }

  get status() {
    return this.productForm.get('status');
  }


  category: Category[];

  constructor(private productService: ProductServiceService,
              private categoryService: CategoryServiceService,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getType();
  }

  add() {
    const products: Product = {
      id: this.productForm.value.id,
      name: this.productForm.value.name,
      price: this.productForm.value.price,
      status: this.productForm.value.status,
      category: {
        id: this.productForm.value.category
      },
    };
    this.productService.create(this.productForm.value).subscribe((res) => {
      this.router.navigateByUrl("");
      this.snackBar.open("Create successfully!", "ok");
    })
  }

  getType() {
    this.categoryService.getAllType().subscribe((res) => {
        this.category = res;
      }
    )
  }

}
