package com.turf.repositories;

import com.turf.entities.Booking;

import java.util.List;

public interface BookingRepo {
    Booking addOrUpdateBooking(Booking booking);

    Booking getBookingById(String id);

    List<Booking> getBookingsByCustomerId(String customerId);

    List<Booking> getBookingsByTurfId(String turfId);

}
