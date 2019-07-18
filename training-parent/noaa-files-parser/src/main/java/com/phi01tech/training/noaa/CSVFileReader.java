package com.phi01tech.training.noaa;

import org.omg.SendingContext.RunTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVFileReader<OBJ> {

    public List<OBJ> readFile(File file) {
        try (BufferedReader bufferedReader = createBufferedReader(file)) {
            skipFirstLine(bufferedReader);
            return readFileContent(bufferedReader);
        } catch (IOException e) {
            // swallowing
            throw constructException(e);// rethrow
        }
    }

    protected RuntimeException constructException(IOException e) {
        return new IllegalStateException(e);
    }

    protected BufferedReader createBufferedReader(File stationFile) throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputStream = new FileInputStream(stationFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        return new BufferedReader(reader);
    }

    protected void skipFirstLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }

    protected List<OBJ> readFileContent(BufferedReader bufferedReader) throws IOException {
        List<OBJ> objects = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            objects.add(parseLine(line));
        }
        return objects;
    }

    protected abstract OBJ parseLine(String line);

}
