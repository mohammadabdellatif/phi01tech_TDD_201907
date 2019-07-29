package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.station.GeoLocation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GeoLocationTest {

    public static void main(String[] args) {

        List<String> values = Arrays.asList("Ahmad", "Basel", "Camel", "Dog");
        values.stream()
                .filter(s -> s.contains("a"))
                .sorted()
                .forEach(System.out::println);

        // Fluent API
        GeoLocation geoLocation = GeoLocation
                .builder()
                .latitude(0.0)
                .longitude(90.0)
                .build();

        System.out.println(geoLocation);


    }
}
