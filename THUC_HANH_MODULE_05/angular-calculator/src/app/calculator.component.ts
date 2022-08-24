import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
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
}
