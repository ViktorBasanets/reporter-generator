package org.report.service.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.report.service.CsvReader;

public class CsvFileReaderTest {

    @Test
    void checkReadMethod_shouldReadAllLinesFromTestFile() {
        var lines = new CsvReader("src/test/resources/unit-test-data.csv")
            .read();

        assertEquals(20, lines.size());
        assertEquals(9, lines.get(0).length);
        assertEquals(9, lines.get(lines.size() - 2).length);
        assertEquals(1, lines.get(lines.size() - 1).length);
    }
}
