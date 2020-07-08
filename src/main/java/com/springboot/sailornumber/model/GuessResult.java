package com.springboot.sailornumber.model;

public class GuessResult {
    private final Boolean correct;
    private final Integer nrOfShips;
    private final Integer nrOfBuoys;

    public GuessResult(Boolean correct, Integer ships, Integer buoys) {
        this.correct = correct;
        this.nrOfShips = ships;
        this.nrOfBuoys = buoys;
    }

    public Boolean isCorrect() {
        return correct;
    }

    public Integer getNrOfShips() {
        return nrOfShips;
    }

    public Integer getNrOfBuoys() {
        return nrOfBuoys;
    }
}
