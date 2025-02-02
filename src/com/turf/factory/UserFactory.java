package com.turf.factory;

import com.turf.dto.AddUserRequest;
import com.turf.entities.AbstractUser;
import com.turf.entities.AdminUser;
import com.turf.entities.Customer;

import java.util.UUID;

public class UserFactory {

    public AbstractUser getUser(AddUserRequest addUserRequest) {
        if("ADMIN".equalsIgnoreCase(addUserRequest.getUserrole())) {
            return new AdminUser(UUID.randomUUID().toString(), addUserRequest.getName(), addUserRequest.getPhone());
        } else if ("CUSTOMER".equalsIgnoreCase(addUserRequest.getUserrole())) {
            return new Customer(UUID.randomUUID().toString(), addUserRequest.getName(), addUserRequest.getPhone());
        } else {
            System.out.println("No such user type is supported");
        }
        return null;
    }
}
