package com.phi01tech.training.noaa;

import com.phi01tech.training.noaa.station.GeoLocation;
import com.phi01tech.training.noaa.station.Station;
import com.phi01tech.training.noaa.station.TXTStationFileReader;

import java.io.File;
import java.util.List;

public class StationTest {

    public static void main(String[] args) {
        TXTStationFileReader fileReader = new TXTStationFileReader();

        List<Station> stations = fileReader.readStations(new File("./Stations.txt"));

        for (Station station : stations) {
            GeoLocation geoLocation = station.getGeoLocation();
            System.out.printf("%s,%f,%f%n",
                    station.getStationName(),
                    geoLocation == null ? 0 : geoLocation.latitude(),
                    geoLocation == null ? 0 : geoLocation.longitude());
        }
    }
}
