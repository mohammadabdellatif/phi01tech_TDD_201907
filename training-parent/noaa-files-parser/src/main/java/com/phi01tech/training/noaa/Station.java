package com.phi01tech.training.noaa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Station {

    private String id;                  // USAF = Air Force station ID. May contain a letter in the first position.

    private String wban;                  //  WBAN = NCDC WBAN number

    private String stationName;

    private String country;             // CTRY = FIPS country ID

    private String state;               // State for US stations

    private String icaoId;

    private String latitude;            // LAT = Latitude in thousandths of decimal degrees

    private String longitude;           // LON = Longitude in thousandths of decimal degrees

    private String elevation;           // ELEV = Elevation in meters

    private Long begin;                 //BEGIN = Beginning Period Of Record (YYYYMMDD).

    private Long end;                   //END = Ending Period Of Record (YYYYMMDD).


    public Station(String id, String wban, String stationName, String country, String state, String icaoId, String latitude, String longitude, String elevation, Long begin, Long end) {
        this.id = id;
        this.wban = wban;
        this.stationName = stationName;
        this.country = country;
        this.state = state;
        this.icaoId = icaoId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.begin = begin;
        this.end = end;
    }

    public Station() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIcaoId() {
        return icaoId;
    }

    public void setIcaoId(String icaoId) {
        this.icaoId = icaoId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public Long getBegin() {
        return begin;
    }

    public void setBegin(Long begin) {
        this.begin = begin;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
