package com.turf.entities;

public enum GameType {
    BADMINTON("Badminton"),
    CRICKET("Cricket"),
    FOOTBALL("Football");

    private String value;

    GameType (String value) {
        this.value = value;
    }
}
