package org.report;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.report.client.ReportGenerator;
import org.report.data.Column;
import org.report.data.EffortTeamData;
import org.report.data.EffortTeamReport;
import org.report.data.Team;
import org.report.service.DataAdapter;
import org.report.service.Reporter;
import org.report.service.adapter.EffortIndiaTeamDataAdapter;
import org.report.service.adapter.EffortKyivTeamDataAdapter;
import org.report.service.adapter.EffortLondonTeamDataAdapter;
import org.report.service.adapter.EffortNYTeamDataAdapter;
import org.report.service.adapter.EffortUITeamDataAdapter;
import org.report.service.reader.CsvFileReader;
import org.report.service.report.EffortIndiaTeamDataReport;
import org.report.service.report.EffortKyivTeamDataReport;
import org.report.service.report.EffortLondonTeamDataReport;
import org.report.service.report.EffortNYTeamDataReport;
import org.report.service.report.EffortUITeamDataReport;

public class App {

    public static void main(String[] args) {
        var filePath = Optional.ofNullable(args)
            .filter(ars -> ars.length == 1)
            .orElseThrow(() -> new RuntimeException("You need to pass a link to a single input-data file"))
            [0];

        Map<String, DataAdapter<EffortTeamData>> adapters = Map.of(
            Team.UI.value(), new EffortUITeamDataAdapter(),
            Team.LONDON.value(), new EffortLondonTeamDataAdapter(),
            Team.NY.value(), new EffortNYTeamDataAdapter(),
            Team.KYIV.value(), new EffortKyivTeamDataAdapter(),
            Team.INDIA.value(), new EffortIndiaTeamDataAdapter()
        );

        Map<String, Reporter<EffortTeamData, EffortTeamReport>> reporters = Map.of(
            Team.UI.value(), new EffortUITeamDataReport(),
            Team.LONDON.value(), new EffortLondonTeamDataReport(),
            Team.NY.value(), new EffortNYTeamDataReport(),
            Team.KYIV.value(), new EffortKyivTeamDataReport(),
            Team.INDIA.value(), new EffortIndiaTeamDataReport()
        );

        List<EffortTeamReport> report = new ReportGenerator<>(new CsvFileReader(filePath), adapters, reporters)
            .generateReport();

        System.out.println(Column.toRow(Column.TEAM_EFFORT, Column.TOTAL_EFFORT, Column.REMAINING_EFFORT));
        report.forEach(System.out::println);
    }
}