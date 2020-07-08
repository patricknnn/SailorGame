package com.springboot.sailornumber.model;

import java.util.List;

public class GameStats {
    private final Game game;
    private final List<Guess> guesses;

    public GameStats(Game game, List<Guess> guesses) {
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
