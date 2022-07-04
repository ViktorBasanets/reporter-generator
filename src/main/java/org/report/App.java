package org.report;

import java.util.Optional;
import org.report.client.ReportGenerator;
import org.report.data.Column;
import org.report.service.CsvReader;
import org.report.service.EffortTeamAdapter;
import org.report.service.EffortTeamReporter;

public class App {

    public static void main(String[] args) {
        var path = Optional.ofNullable(args)
            .filter(ars -> ars.length == 1)
            .orElseThrow(() -> new RuntimeException("You need to pass a link to a single input-data file"))
            [0];

        System.out.println(Column.toRow(Column.TEAM_EFFORT, Column.TOTAL_EFFORT, Column.REMAINING_EFFORT));

        new ReportGenerator<>(new CsvReader(path), new EffortTeamAdapter(), new EffortTeamReporter())
            .generateReport()
            .forEach(System.out::println);
    }
}