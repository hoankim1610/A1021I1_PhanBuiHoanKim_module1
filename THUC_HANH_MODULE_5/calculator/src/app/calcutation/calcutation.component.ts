import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calcutation',
  templateUrl: './calcutation.component.html',
  styleUrls: ['./calcutation.component.css']
})
export class CalculationComponent implements OnInit{
  num1: number;
  num2: number;
  operation: string;
  result: number;

  changeNum1(target) {
    this.num1 = target;
  }

  changeNum2(target) {
    this.num2 = target;
  }

  changeOperation(target) {
    this.operation = target;
  }

  addition(): number {
    return this.num1 + this.num2;
  }

  subtraction(): number {
    return this.num1 - this.num2;
  }

  multiplication(): number {
    return this.num1 * this.num2;
  }

  division(): number {
    return this.num1 / this.num2;
  }

  calculate() {
    switch (this.operation) {
      case '+':
        this.result = this.addition();
        break;
      case '-':
        this.result = this.subtraction();
        break;
      case '*':
        this.result = this.multiplication();
        break;
      case '/':
        this.result = this.division();
        break;
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
