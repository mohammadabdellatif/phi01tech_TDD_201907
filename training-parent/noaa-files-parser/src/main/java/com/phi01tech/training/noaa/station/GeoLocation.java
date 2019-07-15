package com.phi01tech.training.noaa.station;

public class GeoLocation {
    private final Double latitude;
    private final Double longitude;

    public GeoLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double latitude() {
        return latitude;
    }

    public Double longitude() {
        return longitude;
    }
}
