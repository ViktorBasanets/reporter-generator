package org.report.service.adapter;

import java.util.function.Predicate;
import org.report.data.Column;
import org.report.data.EffortTeamData;
import org.report.data.Team;
import org.report.service.BaseEffortDataAdapter;
import org.report.service.DataAdapter;

public class EffortUITeamDataAdapter extends BaseEffortDataAdapter implements DataAdapter<EffortTeamData> {
    @Override
    protected Predicate<String[]> getPredicate() {
        return line -> line[Column.TEAM_INPUT.sequentialNumber()].equals(Team.UI.value());
    }
}
