package org.report.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.report.data.Column;
import org.report.data.EffortTeamData;

public abstract class BaseEffortDataAdapter implements DataAdapter<EffortTeamData> {

    @Override
    public List<EffortTeamData> adapt(List<String[]> lines) {
        return lines.stream()
            .skip(1)
            .filter(line -> line.length > 1 && getPredicate().test(line))
            .map(line -> EffortTeamData.builder()
                .status(line[Column.STATUS.sequentialNumber()])
                .originalEstimate(parseLong(line[Column.ORIGINAL_ESTIMATE.sequentialNumber()]))
                .team(line[Column.TEAM_INPUT.sequentialNumber()])
                .build())
            .filter(issue -> !issue.isEmpty())
            .collect(Collectors.toList());
    }

    protected abstract Predicate<String[]> getPredicate();

    private long parseLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            return 0L;
        }
    }
}
