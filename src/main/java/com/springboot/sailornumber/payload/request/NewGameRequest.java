package com.springboot.sailornumber.payload.request;

import java.time.LocalDate;

public class NewGameRequest {
    private String name;
    private LocalDate dateOfBirth;
    private Integer nrOfDigits;

    public NewGameRequest(String name, LocalDate dateOfBirth, Integer nrOfDigits) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nrOfDigits = nrOfDigits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getNrOfDigits() {
        return nrOfDigits;
    }

    public void setNrOfDigits(Integer nrOfDigits) {
        this.nrOfDigits = nrOfDigits;
    }
}
