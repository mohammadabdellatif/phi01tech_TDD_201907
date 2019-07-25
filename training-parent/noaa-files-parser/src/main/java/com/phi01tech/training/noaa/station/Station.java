package com.phi01tech.training.noaa.station;

public class Station {

    private final String id;
    private final String wban;
    private final String stationName;
    private final String icaoId;
    private final Location location;
    private final GeoLocation geoLocation;
    private final Dates dates;
    private final String elevation;

    public static StationBuilder builder() {
        return new StationBuilder();
    }

    public static StationBuilder builderForId(String id) {
        return builder().withId(id);
    }

    private Station(StationParams param) {
        this.wban = param.wban;
        this.stationName = param.stationName;
        this.location = param.location;
        this.icaoId = param.icaoId;
        this.id = param.id;
        this.geoLocation = param.geoLocation;
        this.elevation = param.elevation;
        this.dates = param.dates;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public String getId() {
        return id;
    }

    public String getWban() {
        return wban;
    }

    public String getStationName() {
        return stationName;
    }

    public Location getLocation() {
        return location;
    }

    public String getElevation() {
        return elevation;
    }

    public Dates getDates() {
        return dates;
    }

    public String getIcaoId() {
        return icaoId;
    }

    public static class StationBuilder {
        private String id;
        private String wban;
        private String stationName;
        private String icaoId;
        private Location location;
        private GeoLocation geoLocation;
        private Dates dates;
        private String elevation;

        private StationBuilder() {

        }

        public StationBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public StationBuilder withWban(String wban) {
            this.wban = wban;
            return this;
        }

        public StationBuilder withName(String stationName) {
            this.stationName = stationName;
            return this;
        }

        public StationBuilder withIcaoId(String icaoId) {
            this.icaoId = icaoId;
            return this;
        }

        public StationBuilder inLocation(Location location) {
            this.location = location;
            return this;
        }

        public StationBuilder onGeoLocation(GeoLocation geoLocation) {
            this.geoLocation = geoLocation;
            return this;
        }

        public StationBuilder atDates(Dates dates) {
            this.dates = dates;
            return this;
        }

        public StationBuilder atElevation(String elevation) {
            this.elevation = elevation;
            return this;
        }

        public Station build() {
            StationParams params = new StationParams();
            params.dates = dates;
            params.elevation = elevation;
            params.geoLocation = geoLocation;
            params.icaoId = icaoId;
            params.wban = wban;
            params.stationName = stationName;
            params.location = location;
            params.id = id;
            return new Station(params);
        }
    }
}
