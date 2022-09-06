import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary-detail-page',
  templateUrl: './dictionary-detail-page.component.html',
  styleUrls: ['./dictionary-detail-page.component.css']
})
export class DictionaryDetailPageComponent implements OnInit {

  mean: string;
  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
  }

}
