package com.turf.dto;

import com.turf.entities.Booking;

import java.time.Instant;

public class BookingRequest {
    private String slotId;
    private String customerId;

    public BookingRequest(String slotId, String customerId) {
        this.slotId = slotId;
        this.customerId = customerId;
    }

    public Booking intoInitiatedBooking() {
        return new Booking(customerId, Instant.now(), "INITIATED", slotId);
    }
}
