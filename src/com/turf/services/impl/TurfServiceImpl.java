package com.turf.services.impl;

import com.turf.entities.Slot;
import com.turf.entities.Turf;
import com.turf.repositories.SlotRepo;
import com.turf.repositories.TurfRepo;
import com.turf.repositories.UserRepo;
import com.turf.services.ITurfService;
import com.turf.services.IUserService;

import java.util.List;
import java.util.Objects;

public class TurfServiceImpl implements ITurfService {
    public static final String NOT_A_VALID_ADMIN = "Not a valid Admin";
    public static final String NO_TURF_FOUND = "No turf found";
    public static final String PLEASE_ENTER_VALID_TURF_ID = "Please enter valid turf id";
    public static final String YOU_CAN_T_ADD_SLOTS_TO_THIS_TURF = "You can't add slots to this turf!";
    private TurfRepo turfRepo;
    private SlotRepo slotRepo;
    private IUserService userService;

    public TurfServiceImpl(IUserService userService, TurfRepo turfRepo, SlotRepo slotRepo) {
        this.userService = userService;
        this.turfRepo = turfRepo;
        this.slotRepo = slotRepo;
    }

    @Override
    public boolean addTurf(Turf turf, String adminId) {
        if(Objects.nonNull(adminId) && userService.getUserById(adminId) != null) {
            if(!userService.getUserById(adminId).getUserrole().equalsIgnoreCase("ADMIN")){
                System.out.println(NOT_A_VALID_ADMIN + " " + adminId);
            } else {
                turfRepo.addTurf(turf);
                return true;
            }
        } else {
            System.out.println(NOT_A_VALID_ADMIN + " " + adminId);
        }
        return false;
    }

    @Override
    public boolean addSlots(String adminId, String turfId, List<Slot> slotList) {
        if(Objects.nonNull(adminId) && userService.getUserById(adminId) != null) {
            if(!userService.getUserById(adminId).getUserrole().equalsIgnoreCase("ADMIN")){
                System.out.println(NOT_A_VALID_ADMIN);
            }
            List<Turf> turf = turfRepo.getTurfsOwnedByAdmin(adminId);
            if(turf == null) {
                System.out.println(YOU_CAN_T_ADD_SLOTS_TO_THIS_TURF);
            }
            Turf turf1 = turf.stream().filter(x -> x.getId() == turfId).findFirst().orElse(null);
            if(turf1 == null) {
                System.out.println(YOU_CAN_T_ADD_SLOTS_TO_THIS_TURF);
            }
            for(Slot slot: slotList) {
                slot.setTurfId(turfId);
                slotRepo.addSlot(slot);
            }
            return true;
        } else {
            System.out.println(NOT_A_VALID_ADMIN);
        }
        return false;
    }

    @Override
    public Turf getTurfDetails(String turfId) {
        if(Objects.nonNull(turfId) && !turfId.equalsIgnoreCase("")) {
            Turf turf = turfRepo.getTurfById(turfId);
            if(turf == null)  {
                System.out.println(NO_TURF_FOUND);
            }
            return turf;
        } else {
            System.out.println(PLEASE_ENTER_VALID_TURF_ID);
        }

        return null;
    }

    public boolean validateTurfAndAdmin(String turfId, String adminId) {
        if(Objects.nonNull(adminId) && userService.getUserById(adminId) != null) {
            if(!userService.getUserById(adminId).getUserrole().equalsIgnoreCase("ADMIN")){
                System.out.println(NOT_A_VALID_ADMIN);
            }
            List<Turf> turf = turfRepo.getTurfsOwnedByAdmin(adminId);
            if(turf == null) {
                System.out.println(YOU_CAN_T_ADD_SLOTS_TO_THIS_TURF);
            }
            Turf turf1 = turf.stream().filter(x -> x.getId() == turfId).findFirst().orElse(null);
            if(turf1 == null) {
                System.out.println(YOU_CAN_T_ADD_SLOTS_TO_THIS_TURF);
            }
            return true;
        } else {
            System.out.println(NOT_A_VALID_ADMIN);
        }
        return false;
    }

    @Override
    public List<Slot> getAllFutureSlotsForTurfId(String turfId) {
        Turf turf = this.getTurfDetails(turfId);
        if(Objects.nonNull(turf)) {
            return this.slotRepo.getSlotsByTurfId(turfId);
        }

        return null;
    }
}
