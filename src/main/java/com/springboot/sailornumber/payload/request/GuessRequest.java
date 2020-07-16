package com.springboot.sailornumber.payload.request;

public class GuessRequest {
    private Long gameId;
    private String guess;

    public GuessRequest(Long gameId, String guess) {
        this.gameId = gameId;
        this.guess = guess;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    @Override
    public String toString() {
        return "GuessRequest{" + "gameId=" + gameId + ", guess='" + guess + '\'' + '}';
    }
}
