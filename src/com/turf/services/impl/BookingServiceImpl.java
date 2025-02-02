package com.turf.services.impl;

import com.turf.dto.BookingRequest;
import com.turf.entities.Booking;
import com.turf.entities.Slot;
import com.turf.entities.Status;
import com.turf.repositories.BookingRepo;
import com.turf.services.IBookingService;
import com.turf.services.ISlotService;
import com.turf.services.ITurfService;
import com.turf.services.IUserService;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;

public class BookingServiceImpl implements IBookingService {

    public static final String SLOT_CAN_T_BE_BOOKED = "Slot can't be booked!";
    public static final String CUSTOMER_ID_CAN_T_BE_EMPTY = "Customer id can't be empty";
    public static final String NOT_A_VALID_BOOKING = "Not a valid booking!";
    private BookingRepo bookingRepo;
    private ITurfService turfService;
    private IUserService userService;
    private ISlotService slotService;

    public BookingServiceImpl(BookingRepo bookingRepo, ITurfService turfService, IUserService userService, ISlotService slotService) {
        this.bookingRepo = bookingRepo;
        this.turfService = turfService;
        this.userService = userService;
        this.slotService = slotService;
    }

    @Override
    public List<Booking> getAllBookingsByTurfId(String turfId, String adminId) {
        if(!turfService.validateTurfAndAdmin(turfId, adminId)) {
            return null;
        }
        return this.bookingRepo.getBookingsByTurfId(turfId);
    }

    @Override
    public Booking initiateBooking(BookingRequest bookingRequest) {
        this.userService.getUserById(bookingRequest.getCustomerId());
        Slot slot = this.slotService.getSlotById(bookingRequest.getSlotId());
        if(slot.getStartDateTime().isAfter(Instant.now().atOffset(ZoneOffset.UTC)) || !slot.getStatus().equalsIgnoreCase("AVAILABLE")) {
            System.out.println(bookingRequest.getSlotId() + ":: " + SLOT_CAN_T_BE_BOOKED);
        }
        this.slotService.updateSlotStatus(bookingRequest.getSlotId(), Status.BOOKED.toString());
        return this.bookingRepo.addOrUpdateBooking(bookingRequest.intoInitiatedBooking());
    }

    @Override
    public void updateBookingStatus(String bookingId, String updatedState) {
        Booking booking = this.bookingRepo.getBookingById(bookingId);
        if(Objects.nonNull(booking)) {
            booking.setStatus(updatedState);  // This transition can be validated
            this.bookingRepo.addOrUpdateBooking(booking);
        } else {
            System.out.println(NOT_A_VALID_BOOKING);
        }
    }

    @Override
    public List<Booking> getAllBookingsForCustomer(String customerId) {
        if(Objects.nonNull(customerId)) {
            return this.bookingRepo.getBookingsByCustomerId(customerId);
        }
        System.out.println(CUSTOMER_ID_CAN_T_BE_EMPTY);
        return null;
    }


}
