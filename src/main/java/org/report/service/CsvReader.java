package org.report.service;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader implements Reader<String[]> {

    private final String path;

    public CsvReader(String path) {
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
