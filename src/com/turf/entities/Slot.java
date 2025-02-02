package com.turf.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Slot {
    private String id;
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private String turfId;
    private GameType gameType;

    public Slot(OffsetDateTime startDateTime, OffsetDateTime endDateTime, GameType gameType) {
        this.id = UUID.randomUUID().toString();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.gameType = gameType;
    }

    public Slot(OffsetDateTime startDateTime, OffsetDateTime endDateTime, String turfId, GameType gameType) {
        this.id = UUID.randomUUID().toString();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.turfId = turfId;
        this.gameType = gameType;
    }

    public String getId() {
        return id;
    }

    public OffsetDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(OffsetDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public OffsetDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(OffsetDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getTurfId() {
        return turfId;
    }

    public void setTurfId(String turfId) {
        this.turfId = turfId;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
