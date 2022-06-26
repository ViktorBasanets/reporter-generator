package org.report.service.report;

import org.report.data.EffortTeamData;
import org.report.data.EffortTeamReport;
import org.report.data.Team;
import org.report.service.BaseReport;
import org.report.service.Reporter;

public class EffortIndiaTeamDataReport extends BaseReport<EffortTeamData, EffortTeamReport>
    implements Reporter<EffortTeamData, EffortTeamReport> {

    @Override
    public EffortTeamReport createReport() {
        return EffortTeamReport.builder()
            .team(Team.INDIA.value())
            .totalEffort(data)
            .remainingEffort(data)
            .build();
    }
}
