package com.springboot.sailornumber.service;
import com.springboot.sailornumber.model.GuessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GameLogic {
    Logger logger = LoggerFactory.getLogger(GameLogic.class);

    public GameLogic() {}

    /**
     * Compares 2 given integers
     * @param nrToGuess The number to guess
     * @param userGuess The user's guess
     * @return Result of the comparison
     */
    public GuessResult getGuessResult(String nrToGuess, String userGuess) {
        // Initialize variables
        boolean correct = false;
        int nrOfShips = 0, nrOfBuoys = 0;

        // Check for correct guess first
        if (nrToGuess.equals(userGuess)) {
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
