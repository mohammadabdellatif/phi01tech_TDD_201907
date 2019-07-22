package com.phi01tech.training.noaa;

import java.io.IOException;

public interface ExceptionHandler {

    RuntimeException returnProperException(IOException e);
}
