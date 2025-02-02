package com.turf.services.impl;

import com.turf.dto.BookingRequest;
import com.turf.entities.Booking;
import com.turf.repositories.BookingRepo;
import com.turf.services.IBookingService;

import java.util.List;

public class BookingServiceImpl implements IBookingService {

    private BookingRepo bookingRepo;


    @Override
    public List<Booking> getAllBookingsByTurfId(String turfId, String adminId) {

        return null;
    }

    @Override
    public Booking addBooking(BookingRequest bookingRequest) {
        return this.bookingRepo.addBooking(bookingRequest.intoInitiatedBooking());
    }
}
