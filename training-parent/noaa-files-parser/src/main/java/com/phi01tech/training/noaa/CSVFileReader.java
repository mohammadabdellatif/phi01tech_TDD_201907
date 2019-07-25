package com.phi01tech.training.noaa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CSVFileReader<OBJ> {

    // Strategy Design pattern
    private LineParser<OBJ> lineParser;
    private ExceptionHandler exceptionHandler = new DefaultExceptionHandler();

    public CSVFileReader(LineParser<OBJ> lineParser) {
        this.lineParser = lineParser;
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public List<OBJ> readFile(File file) {
        ArrayList<OBJ> objects = new ArrayList<>();
        readFile(file, objects::add);
        return objects;
    }

    public void readFile(File file, Consumer<OBJ> recordConsumer) {
        try (BufferedReader bufferedReader = createBufferedReader(file)) {
            skipFirstLine(bufferedReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // i need someone to provide me with implementation for this function
                OBJ obj = lineParser.parseLine(line);
                recordConsumer.accept(obj);
            }
        } catch (IOException e) {
            // swallowing
            throw exceptionHandler.returnProperException(e);// rethrow
        }
    }


    protected BufferedReader createBufferedReader(File stationFile)
            throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputStream = new FileInputStream(stationFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        return new BufferedReader(reader);
    }

    protected void skipFirstLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }

    private static class DefaultExceptionHandler implements ExceptionHandler {

        @Override
        public RuntimeException returnProperException(IOException e) {
            return new IllegalStateException(e);
        }
    }

}
