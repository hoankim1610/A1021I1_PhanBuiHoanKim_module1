import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FacilitiesType} from "../../data/facilititiesType";
import {ActivatedRoute, Router} from "@angular/router";
import {FacilitiesService} from "../../service/facilities.service";
import {FacilitiesTypeService} from "../../service/facilitiesType.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Facilities} from "../../data/facilities";

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {

  facilitiesForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', [Validators.required]),
    area: new FormControl('', [Validators.required]),
    cost: new FormControl('', [Validators.required]),
    max: new FormControl('', [Validators.required]),
    rental: new FormControl('', [Validators.required]),
    facilityType: new FormControl('', [Validators.required]),
    standard: new FormControl('', [Validators.required]),
    pool: new FormControl('', [Validators.required]),
    floor: new FormControl('', [Validators.required]),
    image: new FormControl('', [Validators.required]),
  });

  facilitiesType: any = [];

  constructor(private facilitiesService: FacilitiesService,
              private facilitiesTypeService: FacilitiesTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getCategory();
  }

  add() {
    const facilities: Facilities = {
      id: this.facilitiesForm.value.id,
      name: this.facilitiesForm.value.name,
      area: this.facilitiesForm.value.area,
      cost: this.facilitiesForm.value.cost,
      maxPeople: this.facilitiesForm.value.maxPeople,
      rentalType: this.facilitiesForm.value.rentalType,
      facilityType: {
        id: this.facilitiesForm.value.facilityType
      },
      standardRoom: this.facilitiesForm.value.standardRoom,
      poolArea: this.facilitiesForm.value.poolArea,
      floor: this.facilitiesForm.value.floor,
      image: this.facilitiesForm.value.image
    };
    this.facilitiesService.create(this.facilitiesForm.value).subscribe((res) => {
      this.router.navigateByUrl("");
      this.snackBar.open("Create successfully!", "ok");
    })
  }

  getCategory() {
    this.facilitiesTypeService.getAllType().subscribe((res) => {
        this.facilitiesType = res;
      }
    )
  }

}
