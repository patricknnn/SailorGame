# Sailor number guessing game
Web API that plays a number guessing game with the user. 

## Before game starts
* Enter name and date of birth.
* Choose [nrOfDigits] to guess [4-8]
* Start a new game

## The game
* Generates a random number of length [nrOfDigits] to guess
* Takes guess from the user:
    * For each correct digit in the correct place, counts a ‘Ship’
    * For each correct digit, but in the wrong place, counts a ‘Buoy’
* Repeats until player guesses the correct number

## Endpoints
* /api/game/all - returns list of all games
* /api/game/gameId/{id} - returns game
* /api/game/new - create new game
* /api/guess/all - returns list of all guesses
* /api/guess/gameId/{id} - returns list of guesses for game
* /api/guess/guessId/{id} - returns guess
* /api/guess/submit - submit guess

## Entities
The following entities are used:

### Game
* ID
* Name
* Date of birth
* [nrOfDigits] to guess [4-8]
* Random number to guess
* Timestamp of game start

### Guess
* ID
* Game ID
* Guess
* Timestamp of guess

### GuessResult
* Correct
* nrOfShips
* nrOfBuoys


