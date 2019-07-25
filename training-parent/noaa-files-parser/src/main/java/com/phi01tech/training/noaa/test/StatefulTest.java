package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.station.StatefulStationLineParser;
import com.phi01tech.training.noaa.station.Station;
import com.phi01tech.training.noaa.station.StationLineParser;

public class StatefulTest {

    public static void main(String[] args) {
        // services
        StationLineParser statless = new StationLineParser();

        // i am reusing the same instance "Safely"
        Station result = statless.parseLine("1213232323");
        result = statless.parseLine("12132323fkjaf3");
        result = statless.parseLine("121323dfjakjfd3");
        result = statless.parseLine("890853434340");

        StatefulStationLineParser stationLineParser = new StatefulStationLineParser("39887434834394");
        Station station = stationLineParser.parseLine();
        stationLineParser = new StatefulStationLineParser("398fd ffffdfafasdfdas87434834394");
        station = stationLineParser.parseLine();
        stationLineParser = new StatefulStationLineParser("3988fd fffafasf7434834394");
        station = stationLineParser.parseLine();
        stationLineParser = new StatefulStationLineParser("3988fd fffafasf7434834394");
        station = stationLineParser.parseLine();




    }
}
