package com.phi01tech.training.noaa.station;

import java.time.LocalDate;

public class Dates {
    private final LocalDate begin;
    private final LocalDate end;

    public Dates(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public LocalDate begin() {
        return begin;
    }

    public LocalDate end() {
        return end;
    }
}
