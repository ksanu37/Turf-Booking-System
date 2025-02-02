package com.turf.entities;

import java.util.List;
import java.util.UUID;

public class Turf {
    private String id;
    private String name;
    private String adminId;
    private String cityName;
    private List<GameType> supportedGames;

    public Turf(String name, String adminId, String cityName, List<GameType> supportedGames) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.adminId = adminId;
        this.cityName = cityName;
        this.supportedGames = supportedGames;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<GameType> getSupportedGames() {
        return supportedGames;
    }

    public void setSupportedGames(List<GameType> supportedGames) {
        this.supportedGames = supportedGames;
    }

    @Override
    public String toString() {
        return "Turf\n{" +
                "\n   id ='" + id + '\'' +
                ", \n   name ='" + name + '\'' +
                ", \n   adminId ='" + adminId + '\'' +
                ", \n   cityName ='" + cityName + '\'' +
                ", \n   supportedGames =" + supportedGames + "\n" +
                '}';
    }
}
