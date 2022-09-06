import { Injectable } from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dic: Dictionary[] = [
    {
      word: 'Cat',
      trans: 'Meo'
    },
    {
      word: 'Dog',
      trans: 'Cho'
    },
    {
      word: 'Chicken',
      trans: 'Ga'
    },
    {
      word: 'Monkey',
      trans: 'Khi'
    }

  ]
  constructor() { }

  translate (word: string) {
    return this.dic.find((dic) => dic.word == word).trans;
  }

}
