import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Product} from "../data/Product";
import {ActivatedRoute, Router} from "@angular/router";
import {CategoryServiceService} from "../service/category-service.service";
import {ProductServiceService} from "../service/product-service.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

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
