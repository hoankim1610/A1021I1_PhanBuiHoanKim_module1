import { Component, OnInit } from '@angular/core';
import {Customer} from "../../data/customer";
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FacilitiesTypeService} from "../../service/facilitiesType.service";
import {FacilitiesService} from "../../service/facilities.service";
import {Facilities} from "../../data/facilities";

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {

  facilitiesType: any = [];
  facilities: Facilities[];

  constructor(private facilitiesService: FacilitiesService,
              private facilitiesTypeService: FacilitiesTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  facilitiesForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required]),
    area: new FormControl('', [Validators.required]),
    cost: new FormControl('', [Validators.required]),
    max: new FormControl('', [Validators.required]),
    rental: new FormControl('', [Validators.required]),
    facility: new FormControl('', [Validators.required]),
    standard: new FormControl('', [Validators.required]),
    pool: new FormControl('', [Validators.required]),
    floor: new FormControl('', [Validators.required]),
    image: new FormControl('', [Validators.required]),
  });

  ngOnInit(): void {
    this.getType();

    this.facilitiesService.findById(this.activatedRoute.snapshot.params.id).subscribe((data) => {
      this.facilitiesForm.setValue(data);
    })
    this.facilitiesTypeService.getAllType().subscribe((data) => {
      this.facilitiesType = data;
    })
  }

  update() {
    this.facilitiesService.update(this.activatedRoute.snapshot.params.id, this.facilitiesForm.value).subscribe(
      (data) => {
        this.router.navigateByUrl("");
        this.snackBar.open("Update successfully!", "ok")
      });
  }

  getType() {
    this.facilitiesTypeService.getAllType().subscribe((res) => {
      this.facilitiesType = res;
    })
  }
}
