import {Guess} from './guess';
import {GuessResult} from './guessresult';

export class GuessResponse {
  constructor(
    public guess: Guess,
    public result: GuessResult,
  ) {
  }
}
