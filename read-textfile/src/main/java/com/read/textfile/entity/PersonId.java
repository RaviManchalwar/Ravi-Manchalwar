package com.read.textfile.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonId implements Serializable {

    private LocalDate dob;
    private int serialNumber;

    public PersonId() {
    }

    public PersonId(LocalDate dob2, int serialNumber) {
        this.dob = dob2;
        this.serialNumber = serialNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    // Implement equals and hashCode methods
}

