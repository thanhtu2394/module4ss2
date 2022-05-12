import { Injectable } from '@angular/core';
import {IWord} from '../iword';

@Injectable({
  providedIn: 'root'
})
export class TranslateService {

  constructor() { }
  iword: IWord[] = [
    {
      word: 'one',
      mean: 'mot',
    },
    {
      word: 'two',
      mean: 'hai',
    },
    {
      word: 'three',
      mean: 'ba',
    }
  ];
  translate(name: string){
    return this.iword.find(item => item.word === name);
  }
  getAll(){
    return this.iword;
  }
  search(name: string){
    return this.iword.find(item => item.word === name);
  }
}
