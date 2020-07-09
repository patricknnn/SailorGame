import {Component, OnInit} from '@angular/core';
import {NewGame} from './model/newgame';
import {GameService} from './service/game.service';
import {Game} from './model/game';
import {Guess} from './model/guess';
import {GuessResult} from './model/guessresult';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular-app';
  newGame: NewGame = new NewGame();
  game: Game;
  guessList: Guess[];
  guessResult: GuessResult;
  currentGuess: Guess = new Guess();
  showStats = false;
  playerWon: false;
  ships = 0;
  buoys = 0;

  constructor(private gameService: GameService) { }

  ngOnInit(): void {
    this.reset();
  }

  reset(): void {
    this.newGame = new NewGame();
    this.game = null;
    this.guessList = null;
    this.guessResult = null;
    this.currentGuess = new Guess();
    this.showStats = false;
    this.playerWon = false;
    this.ships = 0;
    this.buoys = 0;
  }

  onSubmitNewGame(): void {
    this.newGame.dateOfBirth = new Date().getDate();
    this.gameService.newGame(this.newGame)
      .subscribe(data => {
        console.log(data);
        this.game = data;
      }, error => console.log(error));
  }

  onSubmitGuess(): void {
    this.currentGuess.gameId = this.game.id;
    this.gameService.submitGuess(this.currentGuess)
      .subscribe(data => {
        console.log(data);
        // Reset current guess
        this.currentGuess = new Guess();
        // Process data received
        this.guessResult = data.result;
        this.guessList.push(data.guess);
      }, error => console.log(error));
  }

  toggleStats(): void {
    this.showStats ? this.showStats = false : this.showStats = true;
  }
}
