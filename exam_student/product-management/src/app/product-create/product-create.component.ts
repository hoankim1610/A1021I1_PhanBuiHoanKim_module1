import {Component, OnInit} from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;

  constructor(private productService: ProductServiceService,
              private router: Router,
              private snackBar : MatSnackBar) {
  }

  ngOnInit(): void {
    this.productForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
    })
  }

  add() {
    this.productService.create(this.productForm.value).subscribe(
      (res) => {
        this.router.navigateByUrl("");
        this.snackBar.open("Create successfully!", "ok");
      }
    )
  }

}
