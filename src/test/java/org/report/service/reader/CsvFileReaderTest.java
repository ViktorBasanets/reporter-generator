package org.report.service.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CsvFileReaderTest {

    @Test
    void checkReadMethod_shouldReadAllLinesFromTestFile() {
        var testFilePath = "src/test/resources/unit-test-data.csv";
        var reader = new CsvFileReader(testFilePath);
        var lines = reader.read();

        assertEquals(20, lines.size());
        assertEquals(9, lines.get(0).length);
        assertEquals(9, lines.get(lines.size() - 2).length);
        assertEquals(1, lines.get(lines.size() - 1).length);
    }
}
