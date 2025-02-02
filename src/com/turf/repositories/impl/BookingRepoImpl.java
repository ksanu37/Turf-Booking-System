package com.turf.repositories.impl;

import com.turf.entities.Booking;
import com.turf.repositories.BookingRepo;

import java.util.*;

public class BookingRepoImpl implements BookingRepo {

    private Map<String, Booking> bookingMap;
    private Map<String, List<String>> customerBookingMap;
    private Map<String, List<String>> turfBookingMap;
    private static BookingRepoImpl instance;


    private BookingRepoImpl() {
        this.bookingMap = new HashMap<>();
        this.turfBookingMap = new HashMap<>();
        this.customerBookingMap = new HashMap<>();
    }

    public static BookingRepoImpl getInstance() {
        if(Objects.isNull(instance)) {
            instance = new BookingRepoImpl();
        }
        return instance;
    }



    @Override
    public Booking addOrUpdateBooking(Booking booking) {
        bookingMap.put(booking.getId(), booking);
        Booking updatedBooking = bookingMap.get(booking.getId());
                List<String> customerBookings = customerBookingMap.getOrDefault(booking.getBookedBy(), new ArrayList<>());
        if(!customerBookings.contains(updatedBooking.getId())) {
            customerBookings.add(booking.getId());
            customerBookingMap.put(booking.getBookedBy(), customerBookings);
        }
        List<String> turfBookings = turfBookingMap.getOrDefault(booking.getBookedBy(), new ArrayList<>());
        if(!turfBookings.contains(updatedBooking.getId())) {
            turfBookings.add(booking.getId());
            turfBookingMap.put(booking.getBookedBy(), turfBookings);
        }
        return updatedBooking;
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingMap.getOrDefault(id, null);
    }

    @Override
    public List<Booking> getBookingsByCustomerId(String customerId) {
        List<String> customerBookings = customerBookingMap.getOrDefault(customerId, new ArrayList<>());
        if(Objects.isNull(customerBookings) || customerBookings.isEmpty()) {
            return null;
        }
        return customerBookings.stream().map(this::getBookingById).toList();
    }

    @Override
    public List<Booking> getBookingsByTurfId(String turfId) {
        List<String> turfBookings = customerBookingMap.getOrDefault(turfId, new ArrayList<>());
        if(Objects.isNull(turfBookings) || turfBookings.isEmpty()) {
            return null;
        }
        return turfBookings.stream().map(this::getBookingById).toList();
    }
}
