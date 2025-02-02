package com.turf.entities;

public class Customer extends AbstractUser {
    public Customer(String id, String name, String phone) {
        super(id, name, phone, "CUSTOMER");
    }
}
