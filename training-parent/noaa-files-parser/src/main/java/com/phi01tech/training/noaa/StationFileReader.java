package com.phi01tech.training.noaa;

import java.io.File;
import java.util.List;

public interface StationFileReader {

    List<Station> readStations(File stationFile);



}
