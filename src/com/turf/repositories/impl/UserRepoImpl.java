package com.turf.repositories.impl;

import com.turf.entities.AbstractUser;
import com.turf.repositories.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class UserRepoImpl implements UserRepo {

    private Map<String, AbstractUser> userMap;
    private static UserRepoImpl instance;

    private UserRepoImpl() {
        this.userMap = new HashMap<>();
    }

    public static UserRepoImpl getInstance() {
        if(instance == null) {
            instance = new UserRepoImpl();
        }
        return instance;
    }


    @Override
    public AbstractUser getUserById(String id) {
        return userMap.getOrDefault(id, null);
    }

    @Override
    public AbstractUser addUser(AbstractUser abstractUser) {
        userMap.put(abstractUser.getId(), abstractUser);
        return userMap.getOrDefault(abstractUser.getId(), null);
    }
}
