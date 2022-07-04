package org.report.service;

import java.util.ArrayList;
import java.util.List;
import org.report.data.EffortTeamData;
import org.report.data.EffortTeamReport;
import org.report.data.Team;

public class EffortTeamReporter implements Reporter<EffortTeamData, EffortTeamReport> {

    private final List<EffortTeamData> data;

    public EffortTeamReporter() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addRow(EffortTeamData row) {
        data.add(row);
    }

    @Override
    public EffortTeamReport createReport(Team team) {
        return EffortTeamReport.builder()
            .team(team.value())
            .totalEffort(data)
            .remainingEffort(data)
            .build();
    }
}
