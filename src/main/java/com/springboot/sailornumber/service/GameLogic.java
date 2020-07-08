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
        return compareNumbers(game.getNrToGuess(), guess.getGuess());
    }

    /**
     * Compares 2 given integers
     * @param nrToGuess The number to guess
     * @param userGuess The user's guess
     * @return Result of the comparison
     */
    private GuessResult compareNumbers(int nrToGuess, int userGuess) {
        // Initialize variables
        boolean correct = false;
        int nrOfShips = 0, nrOfBuoys = 0;
        String a = Integer.toString(nrToGuess), b = Integer.toString(userGuess);

        // Check for correct guess first
        if (nrToGuess == userGuess) {
            correct = true;
            nrOfShips = a.length();
        } else {
            // Loop the string
            for (int i = 0; i < a.length(); i++) {
                // Correct digit and index
                if (a.charAt(i) == b.charAt(i)) {
                    nrOfShips++;
                } else {
                    // Correct digit wrong index
                    if (a.indexOf(b.charAt(i)) != -1) {
                        nrOfBuoys++;
                    }
                }
            }
        }
        // Return the result
        return new GuessResult(correct, nrOfShips, nrOfBuoys);
    }


}
