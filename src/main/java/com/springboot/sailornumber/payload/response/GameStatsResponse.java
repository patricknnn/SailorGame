package com.springboot.sailornumber.payload.response;

import com.springboot.sailornumber.model.Game;
import com.springboot.sailornumber.model.Guess;

import java.util.List;

public class GameStatsResponse {
    private final Game game;
    private final List<Guess> guesses;

    public GameStatsResponse(Game game, List<Guess> guesses) {
        this.game = game;
        this.guesses = guesses;
    }

    public Game getGame() {
        return game;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }
}
