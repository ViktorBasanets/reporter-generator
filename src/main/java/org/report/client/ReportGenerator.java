package org.report.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.report.data.Team;
import org.report.service.Adapter;
import org.report.service.Reader;
import org.report.service.Reporter;

public class ReportGenerator<T, R, L> {

    private final Reader<L> reader;
    private final Adapter<L, T> adapter;
    private final Reporter<T, R> reporter;

    public ReportGenerator(Reader<L> reader, Adapter<L, T> adapter, Reporter<T, R> reporter) {

        this.reader = reader;
        this.adapter = adapter;
        this.reporter = reporter;
    }

    public List<R> generateReport() {
        var lines = reader.read();

        Arrays.stream(Team.values())
            .flatMap(team -> adapter.adapt(team, lines).stream())
            .forEach(reporter::addRow);

        return Arrays.stream(Team.values())
            .map(reporter::createReport)
            .collect(Collectors.toList());
    }
}