package com.phi01tech.training.noaa.test;

import com.phi01tech.training.noaa.CSVFileReader;
import com.phi01tech.training.noaa.ExceptionHandler;
import com.phi01tech.training.noaa.LineParser;
import com.phi01tech.training.noaa.gsod.GSODParser;
import com.phi01tech.training.noaa.gsod.GlobalSummary;
import com.phi01tech.training.noaa.gsod.GlobalSummaryFileReadException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GSODTest {

    public static void main(String[] args) {
        LineParser<GlobalSummary> parser = new GSODParser();
        CSVFileReader<GlobalSummary> gsodReader = new CSVFileReader<>(parser);
        ExceptionHandler exceptionHandler = new ExceptionHandler() {
            @Override
            public RuntimeException returnProperException(IOException e) {
                return new GlobalSummaryFileReadException("someting went wrong", e);
            }
        };
        gsodReader.setExceptionHandler(exceptionHandler);

        List<GlobalSummary> gsods = gsodReader.readFile(new File("./CDO212647443607df-US.txt"));
        for (GlobalSummary gsod : gsods) {
            System.out.println(gsod.getStationId() + "->" + gsod.getTemp());
        }
    }
}
