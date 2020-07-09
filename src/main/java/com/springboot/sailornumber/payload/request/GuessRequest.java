package com.springboot.sailornumber.payload.request;

public class GuessRequest {
    private Long gameId;
    private Integer guess;

    public GuessRequest(Long gameId, Integer guess) {
        this.gameId = gameId;
        this.guess = guess;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        this.guess = guess;
    }
}
