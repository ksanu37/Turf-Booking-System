package com.turf.repositories.impl;

import com.turf.entities.Slot;
import com.turf.entities.Turf;
import com.turf.repositories.TurfRepo;

import java.util.*;

public class TurfRepoImpl implements TurfRepo {
    private Map<String, Turf> turfMap = new HashMap<>();
    private Map<String, List<String>> adminTurfMap = new HashMap<>();
    private static TurfRepoImpl instance;

    public static TurfRepoImpl getInstance() {
        if(instance == null) {
            instance = new TurfRepoImpl();
        }
        return instance;
    }
    @Override
    public Turf getTurfById(String id) {
        return turfMap.getOrDefault(id, null);
    }

    @Override
    public Turf addTurf(Turf turf) {
        turfMap.put(turf.getId(), turf);
        Turf updatedTurf = turfMap.get(turf.getId());
        List<String> adminTurfs = adminTurfMap.getOrDefault(turf.getAdminId(), new ArrayList<>());
        if(!adminTurfs.contains(updatedTurf.getId())) {
            adminTurfs.add(updatedTurf.getId());
            adminTurfMap.put(turf.getAdminId(), adminTurfs);
        }
        System.out.println("Added Turf :: " + updatedTurf.toString());
        return updatedTurf;
    }

    @Override
    public List<Turf> getTurfsOwnedByAdmin(String adminId) {
        List<String> adminTurfIds = adminTurfMap.getOrDefault(adminId, new ArrayList<>());
        if(Objects.isNull(adminTurfIds) || adminTurfIds.isEmpty()) {
            return null;
        }
        return adminTurfIds.stream().map(this::getTurfById).toList();
    }
}
