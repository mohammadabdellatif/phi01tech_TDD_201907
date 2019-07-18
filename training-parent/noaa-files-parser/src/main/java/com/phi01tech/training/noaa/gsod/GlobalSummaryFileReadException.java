package com.phi01tech.training.noaa.gsod;

public class GlobalSummaryFileReadException extends RuntimeException {

    public GlobalSummaryFileReadException(String message, Exception e) {
        super(message, e);
    }
}
