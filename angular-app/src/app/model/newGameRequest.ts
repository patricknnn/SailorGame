export class NewGameRequest {
  constructor(
    public name: string,
    public dateOfBirth: string,
    public nrOfDigits: number,
  ) {
  }
}
