import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color1: string ;
  constructor() { }

  ngOnInit(): void {
  }

  color2(value: string) {
    this.color1 = value;
    if (value === '1'){
      this.color1 = 'red';
    }
    if (value === '2'){
      this.color1 = 'yellow';
    }
    if (value === '3'){
      this.color1 = 'blue';
    }
    if (value === '4'){
      this.color1 = 'black';
    }

  }
}
