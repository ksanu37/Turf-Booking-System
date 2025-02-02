package com.turf.entities;

public enum Status {
    AVAILABLE("available"),
    BOOKED("booked");

    private String value;

    Status (String value) {
        this.value = value;
    }
}
