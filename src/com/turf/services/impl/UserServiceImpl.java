package com.turf.services.impl;

import com.turf.dto.AddUserRequest;
import com.turf.entities.AbstractUser;
import com.turf.factory.UserFactory;
import com.turf.repositories.UserRepo;
import com.turf.services.IUserService;

import java.util.Objects;

public class UserServiceImpl implements IUserService {
    public static final String FAILURE_IN_ADDING_USER = "Failure in adding user!";
    public static final String NO_USER_FOUND = "No user found";
    private UserFactory userFactory;
    private UserRepo userRepo;

    public UserServiceImpl(UserFactory userFactory, UserRepo userRepo) {
        this.userFactory = userFactory;
        this.userRepo = userRepo;
    }

    public AbstractUser addUser(AddUserRequest addUserRequest) {
        AbstractUser user = this.userFactory.getUser(addUserRequest);
        if(Objects.nonNull(user)) {
           return this.userRepo.addUser(user);
        }
        System.out.println(FAILURE_IN_ADDING_USER);
        return null;
    }

    @Override
    public AbstractUser getUserById(String id) {
        AbstractUser user = this.userRepo.getUserById(id);
        if(Objects.nonNull(user)) {
            return user;
        }
        System.out.println(id + " :: " + NO_USER_FOUND);
        return null;
    }
}
