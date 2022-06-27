package org.report.data;

import java.util.List;
import java.util.Optional;

public class EffortTeamReport {

    private static final String DEFAULT_STORY_POINT = "28800";

    private String team;

    private double totalEffort;

    private double remainingEffort;

    private EffortTeamReport() {}

    public String getTeam() {
        return team;
    }

    public double getTotalEffort() {
        return totalEffort;
    }

    public double getRemainingEffort() {
        return remainingEffort;
    }

    private double getStoryPoint() {
        return Double.parseDouble(Optional.ofNullable(System.getProperty("STORY_POINT")).orElse(DEFAULT_STORY_POINT));
    }

    public static Builder builder() {
        return new EffortTeamReport().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder team(String team) {
            EffortTeamReport.this.team = team;
            return this;
        }

        public Builder totalEffort(List<EffortTeamData> dataList) {
            EffortTeamReport.this.totalEffort = dataList.stream()
                .mapToDouble(data -> data.getOriginalEstimate() / getStoryPoint())
                .sum();
            return this;
        }

        public Builder remainingEffort(List<EffortTeamData> dataList) {
            EffortTeamReport.this.remainingEffort = dataList.stream()
                .filter(issue -> !issue.getStatus().equals(Status.CLOSED_COMPLETE.value())
                    && !issue.getStatus().equals(Status.CLOSED_REJECTED.value()))
                .mapToDouble(issue -> issue.getOriginalEstimate() / getStoryPoint())
                .sum();
            return this;
        }

        public EffortTeamReport build() {
            return EffortTeamReport.this;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %.6f, %6f", team, totalEffort, remainingEffort);
    }
}
