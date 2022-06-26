package org.report.service.reader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.report.service.FileReader;

public class CsvFileReader implements FileReader {

    private final String path;

    public CsvFileReader(String path) {
        this.path = path;
    }

    public List<String[]> read() {
        try (var buffReader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);
            var csvReader = new CSVReaderBuilder(buffReader)
                .withCSVParser(new CSVParserBuilder().build())
                .build()) {

            return csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
