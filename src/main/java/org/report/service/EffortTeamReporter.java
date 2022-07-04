package org.report.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.report.data.EffortTeamData;
import org.report.data.EffortTeamReport;
import org.report.data.Status;

public class EffortTeamReporter implements Reporter<EffortTeamData, EffortTeamReport> {

    private static final String DEFAULT_STORY_POINT = "28800";

    @Override
    public List<EffortTeamReport> reports(List<List<EffortTeamData>> dataList) {
        double storyPoint = getStoryPoint();
        return dataList.stream()
            .map(data -> EffortTeamReport.builder()
                .team(data.get(0).getTeam())
                .totalEffort(data.stream()
                    .mapToDouble(EffortTeamData::getOriginalEstimate)
                    .sum() / storyPoint)
                .remainingEffort(data.stream()
                    .filter(issue -> !issue.getStatus().equals(Status.CLOSED_COMPLETE.value()))
                    .filter(issue -> !issue.getStatus().equals(Status.CLOSED_REJECTED.value()))
                    .mapToDouble(EffortTeamData::getOriginalEstimate)
                    .sum() / storyPoint)
                .build())
            .collect(Collectors.toList());
    }

    private double getStoryPoint() {
        return Double.parseDouble(Optional.ofNullable(System.getProperty("STORY_POINT")).orElse(DEFAULT_STORY_POINT));
    }
}
