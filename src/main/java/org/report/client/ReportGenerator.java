package org.report.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.report.data.Team;
import org.report.service.DataAdapter;
import org.report.service.FileReader;
import org.report.service.Reporter;

public class ReportGenerator<T, R> {

    private final FileReader reader;
    private final Map<String, DataAdapter<T>> adapters;
    private final Map<String, Reporter<T, R>> reporters;

    public ReportGenerator(FileReader rdr, Map<String, DataAdapter<T>> adapters, Map<String, Reporter<T, R>> reporters) {
        this.reader = rdr;
        this.adapters = adapters;
        this.reporters = reporters;
    }

    public List<R> generateReport() {
        var lines = reader.read();
        adapters.forEach((team, adapter) -> {
            Reporter<T, R> reporter = reporters.get(team);
            adapter.adapt(lines).forEach(reporter::addRow);
        });

        return Arrays.stream(Team.values())
            .map(team -> reporters.get(team.value()).createReport())
            .collect(Collectors.toList());
    }
}