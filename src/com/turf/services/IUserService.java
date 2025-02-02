package com.turf.services;

import com.turf.dto.AddUserRequest;
import com.turf.entities.AbstractUser;

public interface IUserService {
    AbstractUser addUser(AddUserRequest addUserRequest);

    AbstractUser getUserById(String id);
}
