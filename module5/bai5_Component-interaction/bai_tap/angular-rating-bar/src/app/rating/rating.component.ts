import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  array: number[] = [1 , 2 , 3 , 4 , 5 , 6 , 7 , 8, 9, 10];
  showIndex1: number;
  constructor() { }

  ngOnInit(): void {
  }

  showIndex(index: number) {
    this.showIndex1 = index;
  }

   getColor(index: number): string {
    if (index < this.showIndex1) { return 'red'; }
  }
}
