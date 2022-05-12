import { Component, OnInit } from '@angular/core';
import {IWord} from '../iword';
import {TranslateService} from '../service/translate.service';
import {ActivatedRoute, RouterLink} from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
word23: IWord;
  constructor(private serve: TranslateService, private activate: ActivatedRoute) { }

  ngOnInit(): void {
    const key = this.activate.snapshot.paramMap.get('name');
    this.word23 = this.serve.translate(key);
  }
}
