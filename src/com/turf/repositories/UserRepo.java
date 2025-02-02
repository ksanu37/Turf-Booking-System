package com.turf.repositories;

import com.turf.entities.AbstractUser;

public interface UserRepo {
    AbstractUser getUserById(String id);
    AbstractUser addUser(AbstractUser abstractUser);
}
