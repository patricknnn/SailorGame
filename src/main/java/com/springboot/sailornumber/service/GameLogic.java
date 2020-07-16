package com.springboot.sailornumber.service;

import com.springboot.sailornumber.exception.ResourceNotFoundException;
import com.springboot.sailornumber.model.Game;
import com.springboot.sailornumber.model.Guess;
import com.springboot.sailornumber.model.GuessResult;
import com.springboot.sailornumber.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    @Autowired
    private GameRepository gameRepository;

    public GameLogic() {}

    /**
     * Evaluates the guess
     * @param guess The user's guess
     * @return Result of the guess
     * @throws ResourceNotFoundException Game not found exception
     */
    public GuessResult guessResult(Guess guess) throws ResourceNotFoundException {
        // Attempt to fetch correct game
        Game game = gameRepository.findById(guess.getGameId()).orElseThrow(
                () -> new ResourceNotFoundException("Game not found for id : " + guess.getGameId())
        );
        // Return the result
        return new GuessResult(false, 2, 2);
        //return compareNumbers(game.getNrToGuess(), guess.getGuess());
    }

    /**
     * Compares 2 given integers
     * @param nrToGuess The number to guess
     * @param userGuess The user's guess
     * @return Result of the comparison
     */
    private GuessResult compareNumbers(String nrToGuess, String userGuess) {
        // Initialize variables
        boolean correct = false;
        int nrOfShips = 0, nrOfBuoys = 0;

        // Check for correct guess first
        if (nrToGuess == userGuess) {
            correct = true;
            nrOfShips = nrToGuess.length();
        } else {
            // Loop the string
            for (int i = 0; i < nrToGuess.length(); i++) {
                // Correct digit and index
                if (nrToGuess.charAt(i) == userGuess.charAt(i)) {
                    nrOfShips++;
                } else {
                    // Correct digit wrong index
                    if (nrToGuess.indexOf(userGuess.charAt(i)) != -1) {
                        nrOfBuoys++;
                    }
                }
            }
        }
        // Return the result
        return new GuessResult(correct, nrOfShips, nrOfBuoys);
    }

}
