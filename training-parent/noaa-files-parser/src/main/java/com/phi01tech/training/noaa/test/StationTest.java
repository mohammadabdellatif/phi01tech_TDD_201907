package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.CSVFileReader;
import com.phi01tech.training.noaa.gsod.CSVGlobalSummaryFileReader;
import com.phi01tech.training.noaa.station.GeoLocation;
import com.phi01tech.training.noaa.station.Station;
import com.phi01tech.training.noaa.station.TXTStationFileReader;

import java.io.File;
import java.util.List;

public class StationTest {
    // TODO we need to add verification for line if it is correct or not
    public static void main(String[] args) {
        CSVFileReader<Station> fileReader = new TXTStationFileReader();

        List<Station> stations = fileReader.readFile(new File("./Stations.txt"));



        for (Station station : stations) {
            GeoLocation geoLocation = station.getGeoLocation();
            System.out.printf("%s,%f,%f%n",
                    station.getStationName(),
                    geoLocation == null ? 0 : geoLocation.latitude(),
                    geoLocation == null ? 0 : geoLocation.longitude());
        }
    }
}
