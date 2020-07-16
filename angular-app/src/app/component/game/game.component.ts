import { Component, OnInit } from '@angular/core';
import {NewGameRequest} from '../../model/newGameRequest';
import {GameService} from '../../service/game.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  loading = false;
  loadingMessage = 'submitting data';
  newGame: NewGameRequest = new NewGameRequest(null, null, null);

  constructor(private gameService: GameService,
              private router: Router) { }

  ngOnInit(): void {
    this.reset();
  }

  reset(): void {
    this.newGame = new NewGameRequest(null, null, null);
  }

  onSubmitNewGame(): void {
    this.loading = true;
    this.gameService.newGame(this.newGame)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['/guess', { id: data }]);
        this.loading = false;
      }, error => console.log(error));
  }


}
