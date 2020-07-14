import { Component, OnInit } from '@angular/core';
import {Game} from "../../model/game";

@Component({
  selector: 'app-won',
  templateUrl: './won.component.html',
  styleUrls: ['./won.component.css']
})
export class WonComponent implements OnInit {
  game: Game;

  constructor() { }

  ngOnInit(): void {
  }

}
