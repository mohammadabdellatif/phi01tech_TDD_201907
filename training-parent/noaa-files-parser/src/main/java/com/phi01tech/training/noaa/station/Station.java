package com.phi01tech.training.noaa.station;

public class Station {

    private String id;
    private String wban;
    private String stationName;
    private String icaoId;
    //embedables
    private Location location;
    private GeoLocation geoLocation;
    private Dates dates;
    private String elevation;

    public Station(StationParams param) {
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

    public void setId(String id) {
        this.id = id;
    }

    public String getWban() {
        return wban;
    }

    public void setWban(String wban) {
        this.wban = wban;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Location getLocation() {
        return location;
    }

    public String getIcaoId() {
        return icaoId;
    }

    public void setIcaoId(String icaoId) {
        this.icaoId = icaoId;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public Dates getDates() {
        return dates;
    }
}
