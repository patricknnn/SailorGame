export class GuessResult {
  constructor(
    public correct: boolean,
    public nrOfShips: number,
    public nrOfBuoys: number,
  ) {
  }
}
