import {Guess} from './guess';
import {GuessResult} from './guessResult';

export class GuessResponse {
  constructor(
    public guess: Guess,
    public guessResult: GuessResult,
  ) {
  }
}
