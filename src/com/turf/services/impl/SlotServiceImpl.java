package com.turf.services.impl;

import com.turf.entities.AbstractUser;
import com.turf.entities.Slot;
import com.turf.repositories.SlotRepo;
import com.turf.services.ISlotService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SlotServiceImpl implements ISlotService {

    public static final String NO_SLOT_FOUND = "No slot found";
    private SlotRepo slotRepo;

    public SlotServiceImpl(SlotRepo instance) {
        this.slotRepo = instance;
    }

    @Override
    public Slot getSlotById(String id) {
        Slot slot = this.slotRepo.getSlotById(id);
        if(Objects.nonNull(slot)) {
            return slot;
        }
        System.out.println(NO_SLOT_FOUND);
        return null;
    }

    @Override
    public Slot addSlot(Slot slot) {
        this.slotRepo.addSlot(slot);
        return null;
    }

    @Override
    public List<Slot> getSlotsByTurfId(String turfId) {
       List<Slot> slotList = this.slotRepo.getSlotsByTurfId(turfId);
       if(Objects.nonNull(slotList) && !slotList.isEmpty()) {
           List<Slot> slots = slotList.stream()
                   .filter(slot -> slot.getStartDateTime().isAfter(Instant.now().atOffset(ZoneOffset.UTC)))
                   .toList();
           return slots;
       }

       System.out.println("No future slots are available!");
       return new ArrayList<>();
    }

    @Override
    public void updateSlotStatus(String slotId, String status) {
        Slot slot = this.slotRepo.getSlotById(slotId);
        if(Objects.isNull(slot)) {
            System.out.println("No slot found with id: " + slotId);
        }

        slot.setStatus(status);
        this.slotRepo.addSlot(slot);
    }


}
