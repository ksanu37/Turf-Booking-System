package com.turf.entities;

public class AdminUser extends AbstractUser{
    public AdminUser(String id, String name, String phone) {
        super(id, name, phone, "ADMIN");
    }
}
