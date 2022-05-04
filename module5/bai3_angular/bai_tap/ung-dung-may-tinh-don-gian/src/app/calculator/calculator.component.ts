import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number2: number;
  number1: number;
  total = 0;
  dau: string;
  tinhtoan(dau: string, n1: string, n2: string) {
    // @ts-ignore
    this.number1 = n1 * 1;
    // @ts-ignore
    this.number2 = n2 * 1;
    this.dau = dau;
    if (this.dau === '+'){
this.total = this.number1 + this.number2;
       }
    if (this.dau === '-'){
      this.total = this.number1 - this.number2;
    }
    if (this.dau === '*'){
      this.total = this.number1 * this.number2;
    }
    if (this.dau === '/'){
      this.total = this.number1 / this.number2;
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

  Number(value: string) {
    return 0;
  }
}
