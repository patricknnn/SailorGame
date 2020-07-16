package com.springboot.sailornumber.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "nrOfDigits", nullable = false)
    private Integer nrOfDigits;
    @Column(name = "nrToGuess", nullable = false)
    private String nrToGuess;
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    /**
     * No arg constructor
     */
    public Game(){}

    /**
     * Constructor for Game
     * @param name Player's name
     * @param dateOfBirth Player's date of birth
     * @param nrOfDigits Nr of digits to guess
     */
    public Game(String name, LocalDate dateOfBirth, Integer nrOfDigits) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nrOfDigits = nrOfDigits;
        this.nrToGuess = randomNumber(nrOfDigits);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Generates a random number of specified number of digits
     * @param nrOfDigits Nr of digits to return
     * @return int
     */
    private String randomNumber(Integer nrOfDigits) {
        int m = (int) Math.pow(10, nrOfDigits - 1);
        return Integer.toString(m + new Random().nextInt(9 * m));
    }

    /**
     * Getters
     */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getNrOfDigits() {
        return nrOfDigits;
    }

    public String getNrToGuess() {
        return nrToGuess;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nrOfDigits=" + nrOfDigits +
                ", nrToGuess='" + nrToGuess + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
