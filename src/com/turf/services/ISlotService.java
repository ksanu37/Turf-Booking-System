package com.turf.services;

import com.turf.entities.Slot;

import java.util.List;

public interface ISlotService {
    Slot getSlotById(String id);

    Slot addSlot(Slot slot);

    List<Slot> getSlotsByTurfId(String turfId);

    void updateSlotStatus(String slotId, String status);
}
