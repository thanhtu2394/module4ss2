import { Component, OnInit } from '@angular/core';
import {IWord} from '../iword';
import {TranslateService} from '../service/translate.service';

@Component({
  selector: 'app-translate',
  templateUrl: './translate.component.html',
  styleUrls: ['./translate.component.css']
})
export class TranslateComponent implements OnInit {
word1: IWord[];
a: string;
  constructor(private service: TranslateService) {}

  ngOnInit(): void {
    this.word1 = this.service.getAll();
  }

  search(nanem: HTMLInputElement) {
    this.a = this.service.search(nanem.value).mean;
  }
}
