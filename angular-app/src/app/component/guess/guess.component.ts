import {Component, OnInit} from '@angular/core';
import {Guess} from "../../model/guess";
import {GameService} from "../../service/game.service";
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {Game} from "../../model/game";
import {GuessResult} from "../../model/guessresult";
import {GuessResponse} from "../../model/guessres";

@Component({
  selector: 'app-guess',
  templateUrl: './guess.component.html',
  styleUrls: ['./guess.component.css']
})
export class GuessComponent implements OnInit {
  game: Game;
  currentGuess: Guess = new Guess();
  lastGuess: Guess;
  lastGuessResult: GuessResult;

  constructor(
    private gameService: GameService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    // this.route.queryParams.subscribe(params => {
    //   this.fetchGame(params['id']);
    // });
    this.mockGame();
  }

  mockGame(): void {
    this.game = new Game();
    this.game.id = 1;
    this.game.name = 'Patrick';
    this.game.nrOfDigits = 4;
    this.game.dateOfBirth = "30-06-1992"
    this.lastGuess = new Guess();
    this.lastGuess.guess = '1234';
    this.lastGuess.gameId = 1;
    this.lastGuessResult = new GuessResult();
    this.lastGuessResult.correct = false;
    this.lastGuessResult.nrOfShips = 3;
    this.lastGuessResult.nrOfBuoys = 1;
  }

  fetchGame(id: number): void {
    this.gameService.getGame(id)
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
        // Process data
        this.processData(data);
        // Reset
        this.reset();
      }, error => console.log(error));
  }

  processData(data: GuessResponse): void {
    this.lastGuess = data.guess;
    this.lastGuessResult = data.result;
    // If won, redirect
    if (data.result.correct) {
      this.router.navigate(['/won', {id: this.game.id}]);
    }
  }

  reset(): void {
    this.currentGuess = new Guess();
  }
}
