package com.phi01tech.training.noaa.gsod;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GlobalSummaryFileReaderImpl implements GlobalSummaryFileReader {

    @Override
    public List<GlobalSummary> readGlobalSummaryFile(File globalSummaryFile) {
        List<GlobalSummary> globalSummaries = new ArrayList<>();

        try (InputStream ins = new FileInputStream(globalSummaryFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(ins, "UTF-8"))) {
            skipHeader(br);
            parseLines(globalSummaries, br);
        } catch (IOException e) {

            throw new GlobalSummaryFileReadException("Could not read gsod file.");
        }

        return globalSummaries;
    }

    private void parseLines(List<GlobalSummary> gsods, BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            gsods.add(parseGlobalSummary(line));
        }
    }

    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }

    private GlobalSummary parseGlobalSummary(String line) {
        String stationId = subStringAndRemoveExtraSpaces(0, 7, line);
        String wban = subStringAndRemoveExtraSpaces(7, 14, line);
        String yearModa = subStringAndRemoveExtraSpaces(14, 26, line);
        String temp = subStringAndRemoveExtraSpaces(26, 37, line);
        String dewp = subStringAndRemoveExtraSpaces(37, 46, line);
        String slp = subStringAndRemoveExtraSpaces(46, 57, line);
        String stp = subStringAndRemoveExtraSpaces(57, 68, line);
        String visib = subStringAndRemoveExtraSpaces(68, 79, line);
        String wdsp = subStringAndRemoveExtraSpaces(79, 88, line);
        String mxspd = subStringAndRemoveExtraSpaces(88, 94, line);
        String gust = subStringAndRemoveExtraSpaces(94, 103, line);
        String max = subStringAndRemoveExtraSpaces(103, 112, line);
        String min = subStringAndRemoveExtraSpaces(112, 118, line);
        String prcp = subStringAndRemoveExtraSpaces(118, 125, line);
        String sndp = subStringAndRemoveExtraSpaces(125, 132, line);
        String frshtt = subStringAndRemoveExtraSpaces(132, line.length(), line);
        return GlobalSummary.newBuilder()
                .setStationId(stationId)
                .setWbano(wban)
                .setYearModa(yearModa)
                .setTemp(temp)
                .setDewp(dewp)
                .setSlp(slp)
                .setStp(stp)
                .setVisib(visib)
                .setWdsp(wdsp)
                .setMxspd(mxspd)
                .setGust(gust)
                .setMax(max)
                .setMin(min)
                .setPrcp(prcp)
                .setSndp(sndp)
                .setFrshtt(frshtt)
                .build();
    }


    public String subStringAndRemoveExtraSpaces(int from, int to, String value) {
        value = value.substring(from, to);
        return value.trim().replaceAll(" +", " ");
    }


}
