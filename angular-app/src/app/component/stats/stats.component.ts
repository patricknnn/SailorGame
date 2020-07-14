import { Component, OnInit } from '@angular/core';
import {Game} from "../../model/game";

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
  game: Game;

  constructor() { }

  ngOnInit(): void {
  }

}
