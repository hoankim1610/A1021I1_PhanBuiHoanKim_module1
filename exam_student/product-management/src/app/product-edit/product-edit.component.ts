import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Product} from "../../../../product/src/app/data/Product";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  products : Product;

  constructor(private productService: ProductServiceService,
              private router: Router,
              private active: ActivatedRoute,
              private snackBar : MatSnackBar) {
  }

  productForm = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    status: new FormControl('', [Validators.required]),
    quantity: new FormControl('', [Validators.required]),
  });

  ngOnInit(): void {
    this.productService.findById(this.active.snapshot.params.id).subscribe(
      (data) => {
        this.productForm.setValue(data);
      })
    this.productService.getAll().subscribe((res) => {
      this.products = res;
    })
  }

  editNew() {
    this.productService.update(this.active.snapshot.params.id, this.productForm.value).subscribe(
      (data) => {
      this.router.navigateByUrl("");
      this.snackBar.open("Update succesfully!", "ok")
      });
  }
}
