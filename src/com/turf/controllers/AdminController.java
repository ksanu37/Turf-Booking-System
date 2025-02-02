package com.turf.controllers;

import com.turf.dto.AddSlotRequest;
import com.turf.entities.Booking;
import com.turf.entities.Slot;
import com.turf.entities.Turf;
import com.turf.services.IBookingService;
import com.turf.services.ITurfService;

import java.util.List;

public class AdminController {
    private ITurfService turfService;
    private IBookingService bookingService;
    public boolean addTurf(Turf turf, String adminId) {
        return this.turfService.addTurf(turf, adminId);
    }



    public boolean addSlots(String turfId, List<AddSlotRequest> slotList, String adminId) {
        List<Slot> slots = slotList.stream().map(AddSlotRequest::intoSlot).toList();
        return this.turfService.addSlots(adminId, turfId, slots);
    }

    public List<Booking> viewAllBookings(String turfId, String adminId) {
        return this.bookingService.getAllBookingsByTurfId(turfId, adminId);
    }
}
