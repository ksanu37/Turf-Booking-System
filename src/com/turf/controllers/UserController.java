package com.turf.controllers;

import com.turf.dto.AddUserRequest;
import com.turf.entities.AbstractUser;
import com.turf.services.IUserService;

public class UserController {
    private IUserService userService;
    public AbstractUser addUser(AddUserRequest addUserRequest) {
        return this.userService.addUser(addUserRequest);
    }

    public AbstractUser getUserById(String id) {
        return this.userService.getUserById(id);
    }
}
