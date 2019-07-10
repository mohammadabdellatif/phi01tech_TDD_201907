package com.phi01tech.training.noaa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TXTStationFileReader implements StationFileReader {

    @Override
    public List<Station> readStations(File stationFile) {
        InputStream ins = null;
        Reader r = null;
        BufferedReader br = null;
        List<Station> stations = new ArrayList<>();
        try {
            String s;
            ins = new FileInputStream(stationFile);
            r = new InputStreamReader(ins, "UTF-8");
            br = new BufferedReader(r);
            br.readLine();
            while ((s = br.readLine()) != null) {
                String id = subStringAndRemoveExtraSpaces(0, 6,s);
                String wban = subStringAndRemoveExtraSpaces(6, 13,s);
                String stationName = subStringAndRemoveExtraSpaces(13, 43,s);
                String country = subStringAndRemoveExtraSpaces(43, 48,s);
                String state = subStringAndRemoveExtraSpaces(48, 51,s);
                String call = subStringAndRemoveExtraSpaces(51, 57,s);
                String lat = subStringAndRemoveExtraSpaces(57, 65,s);
                String lon = subStringAndRemoveExtraSpaces(65, 74,s);
                String elev = subStringAndRemoveExtraSpaces(74, 82,s);
                String begin = subStringAndRemoveExtraSpaces(82, 91,s);
                String end = subStringAndRemoveExtraSpaces(91, s.length(),s);
                Station station = new Station(id,wban,stationName,country,state,call,lat,lon,elev,Long.valueOf(begin),Long.valueOf(end));
                stations.add(station);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        }

        return stations;
    }


    public String subStringAndRemoveExtraSpaces(int from, int to, String value) {
        value = value.substring(from,to);
        return value.trim().replaceAll(" +", " ");
    }

}
