package com.phi01tech.training.noaa.station;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class TXTStationFileReader implements StationFileReader {

    private static final DateTimeFormatter DATE_FIELDS_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public List<Station> readStations(File stationFile) {
        try (BufferedReader bufferedReader = createBufferedReader(stationFile)) {
            skipFirstLine(bufferedReader);
            return readFileContent(bufferedReader);
        } catch (IOException e) {
            throw new IllegalStateException(e);// rethrow
        }
    }

    private BufferedReader createBufferedReader(File stationFile) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputStream = new FileInputStream(stationFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        return new BufferedReader(reader);
    }

    private List<Station> readFileContent(BufferedReader bufferedReader) throws IOException {
        List<Station> stations = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stations.add(parseLine(line));
        }
        return stations;
    }

    private Station parseLine(String line) {
        StationParams params = new StationParams();
        params.id = readFixedLengthField(0, 6, line);
        params.wban = readFixedLengthField(6, 13, line);
        params.stationName = readFixedLengthField(13, 43, line);
        params.location = readLocationFields(line);
        params.geoLocation = readGeoLocationFields(line);
        params.icaoId = readFixedLengthField(51, 57, line);
        params.elevation = readFixedLengthField(74, 82, line);
        params.dates = readDatesFields(line);
        return new Station(params);
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
            geoLocation = new GeoLocation(
                    Double.parseDouble(longitude),
                    Double.parseDouble(latitude));
        return geoLocation;
    }

    private void skipFirstLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }


    public String readFixedLengthField(int from, int to, String line) {
        return line.substring(from, to).trim().replaceAll(" +", " ");
    }

}
