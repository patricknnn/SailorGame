
export class GuessRequest {
  constructor(
    public gameId: number,
    public guess: string,
  ) {}
}
