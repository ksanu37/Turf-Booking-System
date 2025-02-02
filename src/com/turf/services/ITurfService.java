package com.turf.services;

import com.turf.entities.Slot;
import com.turf.entities.Turf;

import java.util.List;

public interface ITurfService {
    boolean addTurf(Turf turf, String adminId);

    boolean addSlots(String adminId, String TurfId, List<Slot> slotList);

    Turf getTurfDetails(String turfId);
}
