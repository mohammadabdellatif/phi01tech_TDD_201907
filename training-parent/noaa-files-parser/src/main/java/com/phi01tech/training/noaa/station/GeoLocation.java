package com.phi01tech.training.noaa.station;

public class GeoLocation {
    private final Double latitude;
    private final Double longitude;

    public static LatitudeSetup builder() {
        return new Builder();
    }

    private GeoLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double latitude() {
        return latitude;
    }

    public Double longitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public interface LatitudeSetup {

        LongitudeSetup latitude(Double latitude);
    }

    public interface LongitudeSetup {

        BuildSetup longitude(Double longitude);
    }

    public interface BuildSetup {

        GeoLocation build();
    }

    private static final class Builder implements LatitudeSetup, LongitudeSetup, BuildSetup {

        private Double latitude;
        private Double longitude;


        @Override
        public LongitudeSetup latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        @Override
        public BuildSetup longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        @Override
        public GeoLocation build() {
            return new GeoLocation(latitude, longitude);
        }
    }
}
