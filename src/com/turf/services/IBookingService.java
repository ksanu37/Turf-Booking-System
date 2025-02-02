package com.turf.services;

import com.turf.dto.BookingRequest;
import com.turf.entities.Booking;

import java.util.List;

public interface IBookingService {
    List<Booking> getAllBookingsByTurfId(String turfId, String adminId);
    Booking addBooking(BookingRequest bookingRequest);

}
