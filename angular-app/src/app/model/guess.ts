export class Guess {
  constructor(
    public id: number,
    public gameId: number,
    public guess: string,
    public timestamp: number,
  ) {}
}
