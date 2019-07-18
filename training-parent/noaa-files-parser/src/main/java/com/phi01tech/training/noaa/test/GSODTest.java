package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.CSVFileReader;
import com.phi01tech.training.noaa.gsod.CSVGlobalSummaryFileReader;
import com.phi01tech.training.noaa.gsod.GlobalSummary;
import com.phi01tech.training.noaa.station.TXTStationFileReader;

import java.io.File;
import java.util.List;

public class GSODTest {

    public static void main(String[] args) {
        CSVFileReader<GlobalSummary> gsodReader = new CSVGlobalSummaryFileReader();

        List<GlobalSummary> gsods = gsodReader.readFile(new File("./CDO212647443607df-US.txt"));
        for (GlobalSummary gsod : gsods) {
            System.out.println(gsod.getStationId() + "->" + gsod.getTemp());
        }
    }
}
