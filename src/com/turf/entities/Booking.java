package com.turf.entities;

import java.time.Instant;
import java.util.UUID;

public class Booking {
    private String id;
    private String bookedBy;
    private Instant bookedAt;
    private String status;
    private String slotId;

    public Booking(String bookedBy, Instant bookedAt, String status, String slotId) {
        this.id = UUID.randomUUID().toString();
        this.bookedBy = bookedBy;
        this.bookedAt = bookedAt;
        this.status = status;
        this.slotId = slotId;
    }

    public String getId() {
        return id;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Instant getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Instant bookedAt) {
        this.bookedAt = bookedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
}
