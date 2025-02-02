package com.turf.controllers;

import com.turf.dto.BookingRequest;
import com.turf.entities.Booking;
import com.turf.services.IBookingService;

import java.util.List;

public class BookingController {
    private IBookingService bookingService;
    public void initiateBooking(BookingRequest bookingRequest) {
        this.bookingService.initiateBooking(bookingRequest);
    }

    public List<Booking> getAllBookings(String adminId, String turfId) {
        return this.bookingService.getAllBookingsByTurfId(turfId, adminId);
    }

    public List<Booking> getAllBookingsForCustomerId(String customerId) {
        return this.bookingService.getAllBookingsForCustomer(customerId);
    }
}
