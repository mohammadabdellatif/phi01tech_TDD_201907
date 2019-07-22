package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.CSVFileReader;
import com.phi01tech.training.noaa.LineParser;
import com.phi01tech.training.noaa.station.GeoLocation;
import com.phi01tech.training.noaa.station.Station;
import com.phi01tech.training.noaa.station.StationLineParser;

import java.io.File;
import java.util.List;

public class StationTest {
    // Encapsulate what varies
    // Favor Composition over inheritance
    // Open for extension closed for modification

    // Dependency Injection

    // injector
    public static void main(String[] args) {
        LineParser<Station> parser = new StationLineParser();
        CSVFileReader<Station> fileReader = new CSVFileReader<>(parser);

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
