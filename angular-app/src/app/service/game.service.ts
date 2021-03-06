import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {NewGameRequest} from '../model/newGameRequest';
import {Game} from '../model/game';
import {Guess} from '../model/guess';
import {GuessResponse} from '../model/guessResponse';
import {GuessRequest} from "../model/guessRequest";

const API_URL = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }

  /**
   * Game related
   */
  getAllGames(): Observable<Game[]> {
    return this.http.get<Game[]>(API_URL + 'game/all');
  }
  getGame(id: string): Observable<Game> {
    return this.http.get<Game>(API_URL + 'game/gameId/' + id);
  }
  newGame(data: NewGameRequest): Observable<Game> {
    console.log('Payload: ');
    console.log(data);
    return this.http.post<Game>(API_URL + 'game/new', data);
  }

  /**
   * Guess related
   */
  getAllGuesses(): Observable<Guess[]> {
    return this.http.get<Guess[]>(API_URL + 'guess/all');
  }
  getAllGuessesByGameId(id: number): Observable<any> {
    return this.http.get(API_URL + 'guess/gameId/' + id);
  }
  getGuessById(id: number): Observable<Guess> {
    return this.http.get<Guess>(API_URL + 'guess/guessId/' + id);
  }
  submitGuess(data: GuessRequest): Observable<GuessResponse> {
    console.log('Payload: ');
    console.log(data);
    return this.http.post<GuessResponse>(API_URL + 'guess/submit', data);
  }

  /**
   * Stats related
   */
  getGameStats(id: number): Observable<any> {
    return this.http.get(API_URL + 'stats/gameId/' + id);
  }
}
