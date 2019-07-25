package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.CSVFileReader;
import com.phi01tech.training.noaa.LineParser;
import com.phi01tech.training.noaa.station.GeoLocation;
import com.phi01tech.training.noaa.station.Station;
import com.phi01tech.training.noaa.station.StationLineParser;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;

public class StationTest {
    // Encapsulate what varies
    // Favor Composition over inheritance
    // Open for extension closed for modification

    // Dependency Injection

    // injector
    public static void main(String[] args) {
        LineParser<Station> parser = new StationLineParser();
        CSVFileReader<Station> fileReader = new CSVFileReader<>(parser);


        Instant start = Instant.now();
        fileReader.readFile(new File("./Stations.txt"), StationTest::pintStationInfo);
        Duration duration = Duration.between(start, Instant.now());
        System.out.println(duration.getSeconds());
    }

    private static void pintStationInfo(Station station) {
        GeoLocation geoLocation = station.getGeoLocation();
        System.out.printf("%s,%f,%f%n",
                station.getStationName(),
                geoLocation == null ? 0 : geoLocation.latitude(),
                geoLocation == null ? 0 : geoLocation.longitude());
    }


}
