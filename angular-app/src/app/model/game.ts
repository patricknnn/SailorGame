export class Game {
  constructor(
    public id: number,
    public name: string,
    public dateOfBirth: string,
    public nrOfDigits: number,
    public nrToGuess: number,
    public timestamp: number,
  ) {}
}
