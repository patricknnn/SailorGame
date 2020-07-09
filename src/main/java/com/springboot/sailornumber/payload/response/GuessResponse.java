package com.springboot.sailornumber.payload.response;

import com.springboot.sailornumber.model.Guess;
import com.springboot.sailornumber.model.GuessResult;

public class GuessResponse {
    private final Guess guess;
    private final GuessResult guessResult;

    public GuessResponse(Guess guess, GuessResult guessResult) {
        this.guess = guess;
        this.guessResult = guessResult;
    }

    public Guess getGuess() {
        return guess;
    }
    public GuessResult getGuessResult() {
        return guessResult;
    }
}
