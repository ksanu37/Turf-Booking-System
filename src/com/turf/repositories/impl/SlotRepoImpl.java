package com.turf.repositories.impl;

import com.turf.entities.Booking;
import com.turf.entities.Slot;
import com.turf.repositories.SlotRepo;

import java.util.*;

public class SlotRepoImpl implements SlotRepo {

    private Map<String, Slot> slotMap;
    private Map<String, List<String>> turfSlotMapping;
    private static SlotRepoImpl instance;

    private SlotRepoImpl() {
        this.slotMap = new HashMap<>();
        this.turfSlotMapping = new HashMap<>();
    }

    public static SlotRepo getInstance() {
        if(instance == null) {
            instance = new SlotRepoImpl();
        }
        return instance;
    }

    @Override
    public boolean addSlot(Slot slot) {
        slotMap.put(slot.getId(), slot);
        Slot updatedSlot = slotMap.get(slot.getId());
        List<String> turfBookings = turfSlotMapping.getOrDefault(slot.getTurfId(), new ArrayList<>());
        if(!turfBookings.contains(updatedSlot.getId())) {
            turfBookings.add(updatedSlot.getId());
            turfSlotMapping.put(slot.getTurfId(), turfBookings);
        }
        return true;
    }

    @Override
    public Slot getSlotById(String id) {
        return slotMap.getOrDefault(id, null);
    }

    @Override
    public List<Slot> getSlotsByTurfId(String turfId) {
        List<String> turfBookings = turfSlotMapping.getOrDefault(turfId, new ArrayList<>());
        if(Objects.isNull(turfBookings) || turfBookings.isEmpty()) {
            return null;
        }
        return turfBookings.stream().map(this::getSlotById).toList();      }
}
