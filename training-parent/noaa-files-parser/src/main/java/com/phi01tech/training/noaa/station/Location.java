package com.phi01tech.training.noaa.station;

public class Location {// location
    private final String country;
    private final String state;

    public Location(String country, String state) {
        this.country = country;
        this.state = state;
    }

    public String country() {
        return country;
    }

    public String state() {
        return state;
    }
}