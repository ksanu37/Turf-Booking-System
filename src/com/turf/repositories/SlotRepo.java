package com.turf.repositories;

import com.turf.entities.Slot;

public interface SlotRepo {
    boolean addSlot(Slot slot);

    Slot getSlotById(String id);
}
