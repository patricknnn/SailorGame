# Sailor number guessing game
Web API that plays a number guessing game with the user. 

## Before game starts
* Enter name and date of birth.
* Choose [nrOfDigits] to guess [4-8]
* Start a new game

## The game
* Generates a random number of length [nrOfDigits] to guess
* Take the input as a whole and return the following hint:
    * For each correct digit in the correct place, counts a ‘Ship’
    * For each correct digit, but in the wrong place, counts a ‘Buoy’
* Repeats until player guesses the correct number

## Entities
The following entities are used based on the above requirements:

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


