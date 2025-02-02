package com.turf.controllers;

import com.turf.dto.BookingRequest;
import com.turf.entities.Booking;
import com.turf.entities.Slot;
import com.turf.services.IBookingService;
import com.turf.services.ITurfService;
import com.turf.services.IUserService;
import com.turf.services.impl.UserServiceImpl;

import java.util.List;

public class CustomerController {
    private IUserService userService;
    private ITurfService turfService;
    private IBookingService bookingService;
    public List<Slot> getSlotsForTurfId(String turfId) {
        return this.turfService.getAllFutureSlotsForTurfId(turfId);
    }

    public Booking bookSlot(BookingRequest bookingRequest) {
        return this.bookingService.initiateBooking(bookingRequest);
    }

    public void updateBooking(String bookingId, String status) {
        this.bookingService.updateBookingStatus(bookingId, status);
    }
}
