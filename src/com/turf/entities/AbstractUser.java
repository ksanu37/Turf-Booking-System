package com.turf.entities;

public abstract class AbstractUser {
    private String id;
    private String name;
    private String phone;
    private String userrole;  // can be a list going forward

    public AbstractUser(String id, String name, String phone, String userrole) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.userrole = userrole;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", userrole='" + userrole + '\'' +
                '}';
    }
}
