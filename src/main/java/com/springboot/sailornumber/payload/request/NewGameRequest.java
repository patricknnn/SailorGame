package com.springboot.sailornumber.payload.request;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NewGameRequest {
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate dateOfBirth;
    @NotBlank
    private Integer nrOfDigits;

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
