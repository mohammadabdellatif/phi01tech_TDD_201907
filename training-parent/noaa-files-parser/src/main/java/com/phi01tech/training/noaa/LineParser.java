package com.phi01tech.training.noaa;

// Design by contract
public interface LineParser<T> {

    T parseLine(String line);
}
