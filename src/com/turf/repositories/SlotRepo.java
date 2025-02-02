package com.turf.repositories;

import com.turf.entities.Slot;

import java.util.List;

public interface SlotRepo {
    boolean addSlot(Slot slot);

    Slot getSlotById(String id);
    List<Slot> getSlotsByTurfId(String turfId);
}
