package com.turf.repositories;

import com.turf.entities.Turf;

import java.util.List;

public interface TurfRepo {
    Turf getTurfById(String id);

    Turf addTurf(Turf turf);

    List<Turf> getTurfsOwnedByAdmin(String adminId);
}
