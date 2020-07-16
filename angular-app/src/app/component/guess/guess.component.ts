import {Component, OnInit} from '@angular/core';
import {Guess} from '../../model/guess';
import {GameService} from '../../service/game.service';
import {Router, ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';
import {switchMap} from 'rxjs/operators';
import {Game} from '../../model/game';
import {GuessResult} from '../../model/guessResult';
import {GuessResponse} from '../../model/guessResponse';
import {GuessRequest} from "../../model/guessRequest";

@Component({
  selector: 'app-guess',
  templateUrl: './guess.component.html',
  styleUrls: ['./guess.component.css']
})
export class GuessComponent implements OnInit {
  loading = false;
  loadingMessage = 'loading';
  game: Game;
  guessRequest: GuessRequest = new GuessRequest(null, null);
  lastGuess: Guess;
  lastGuessResult: GuessResult;

  constructor(
    private gameService: GameService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.fetchGame(id);
  }

  fetchGame(id: string): void {
    this.loadingMessage = 'fetching game';
    this.loading = true;
    this.gameService.getGame(id)
      .subscribe(data => {
        console.log('response:');
        console.log(data);
        this.game = data;
        this.loading = false;
      }, error => console.log(error));
  }

  onSubmitGuess(): void {
    this.loadingMessage = 'submitting guess';
    this.loading = true;
    this.guessRequest.gameId = this.game.id;
    this.gameService.submitGuess(this.guessRequest)
      .subscribe(data => {
        console.log('response:');
        console.log(data);
        // Process data
        this.processData(data);
        // Reset
        this.reset();
        this.loading = false;
      }, error => console.log(error));
  }

  processData(data: GuessResponse): void {
    this.lastGuess = data.guess;
    this.lastGuessResult = data.guessResult;
    // If won, redirect
    if (data.guessResult.correct) {
      this.router.navigate(['/won', {id: this.game.id}]);
    }
  }

  reset(): void {
    this.guessRequest = new GuessRequest(null, null);
  }
}
