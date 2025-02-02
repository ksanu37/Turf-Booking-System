package com.turf.dto;

import com.turf.entities.GameType;
import com.turf.entities.Slot;

import java.time.OffsetDateTime;

public class AddSlotRequest {
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private GameType gameType;

    public AddSlotRequest(OffsetDateTime startDateTime, OffsetDateTime endDateTime, GameType gameType) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.gameType = gameType;
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

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Slot intoSlot() {
        return new Slot(startDateTime, endDateTime, gameType);
    }
}
