package com.phi01tech.training.noaa.station;

import com.phi01tech.training.noaa.LineParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StationLineParser implements LineParser<Station> {

    private static final DateTimeFormatter DATE_FIELDS_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");


    @Override
    public Station parseLine(String line) {
        // fluent APIs
        // Complex (too much fields, immutable,simple complex values
        // Encapsulate and represent complex object construction
        // Fluent style makes it more readable
        // to force object construction to be done from one place
        return Station
                .builderForId(readFixedLengthField(0, 6, line))
                .withWban(readFixedLengthField(6, 13, line))
                .withName(readFixedLengthField(13, 43, line))
                .inLocation(readLocationFields(line))
                .onGeoLocation(readGeoLocationFields(line))
                .withIcaoId(readFixedLengthField(51, 57, line))
                .atElevation(readFixedLengthField(74, 82, line))
                .atDates(readDatesFields(line))
                .build();
    }

    private Dates readDatesFields(String line) {
        LocalDate begin = LocalDate.parse(readFixedLengthField(82, 91, line), DATE_FIELDS_FORMATTER);
        LocalDate end = LocalDate.parse(readFixedLengthField(91, line.length(), line), DATE_FIELDS_FORMATTER);
        return new Dates(begin, end);
    }

    private Location readLocationFields(String line) {
        String country = readFixedLengthField(43, 48, line);
        String state = readFixedLengthField(48, 51, line);
        return new Location(country, state);
    }

    private GeoLocation readGeoLocationFields(String line) {
        String longitude = readFixedLengthField(65, 74, line);
        String latitude = readFixedLengthField(57, 65, line);
        GeoLocation geoLocation = null;
        if (!longitude.isEmpty() && !latitude.isEmpty())
            geoLocation = GeoLocation.builder()
                    .latitude(Double.parseDouble(longitude))
                    .longitude(Double.parseDouble(latitude)).build();
        return geoLocation;
    }

    public String readFixedLengthField(int from, int to, String line) {
        return line.substring(from, to).trim().replaceAll(" +", " ");
    }
}
