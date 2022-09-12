import { Component, OnInit } from '@angular/core';
import {rename} from "fs";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  products : any;

  constructor() { }

  ngOnInit(): void {
  }

}
