package com.turf.dto;

public class AddUserRequest {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserrole() {
        return userrole;
    }

    private String userrole;

    public AddUserRequest(String name, String phone, String userrole) {
        this.name = name;
        this.phone = phone;
        this.userrole = userrole;
    }
}
