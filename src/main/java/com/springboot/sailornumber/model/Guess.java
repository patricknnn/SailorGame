package com.springboot.sailornumber.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "guesses")
public class Guess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gameId", nullable = false)
    private Long gameId;
    @Column(name = "guess", nullable = false)
    private Integer guess;
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    /**
     * No arg constructor
     */
    public Guess(){}

    /**
     * Constructor for Guess
     * @param gameId The game id
     * @param guess The guess
     */
    public Guess(Long gameId, Integer guess) {
        this.gameId = gameId;
        this.guess = guess;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Getters
     */
    public Long getId() {
        return id;
    }

    public Long getGameId() {
        return gameId;
    }

    public Integer getGuess() {
        return guess;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
