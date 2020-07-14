import { Component, OnInit } from '@angular/core';
import {NewGame} from "../../model/newgame";
import {GameService} from "../../service/game.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  newGame: NewGame = new NewGame();

  constructor(private gameService: GameService,
              private router: Router) { }

  ngOnInit(): void {
    this.reset();
  }

  reset(): void {
    this.newGame = new NewGame();
  }

  onSubmitNewGame(): void {
    this.gameService.newGame(this.newGame)
      .subscribe(data => {
        console.log(data.id);
        this.router.navigate(['/guess', { id: data.id }]);
      }, error => console.log(error));
  }


}
