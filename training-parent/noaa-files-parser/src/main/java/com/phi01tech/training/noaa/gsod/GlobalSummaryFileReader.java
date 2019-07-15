package com.phi01tech.training.noaa.gsod;



import java.io.File;
import java.util.List;

public interface GlobalSummaryFileReader {

    List<GlobalSummary> readGlobalSummaryFile(File globalSummaryFile);



}
