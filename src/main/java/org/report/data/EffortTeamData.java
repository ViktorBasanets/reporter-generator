package org.report.data;

import java.util.Objects;

public class EffortTeamData {
    private String status;
    private long originalEstimate;
    private String team;

    public String getStatus() {
        return status;
    }
    public long getOriginalEstimate() {
        return originalEstimate;
    }

    public String getTeam() {
        return team;
    }

    private EffortTeamData(){}

    public static Builder builder() {
        return new EffortTeamData().new Builder();
    }

    public boolean isEmpty() {
        return Objects.isNull(status) && originalEstimate == 0L && Objects.isNull(team);
    }

    public class Builder {
        private Builder(){}

        public Builder status(String status) {
            EffortTeamData.this.status = status;
            return this;
        }

        public Builder originalEstimate(long originalEstimate) {
            EffortTeamData.this.originalEstimate = originalEstimate;
            return this;
        }

        public Builder team(String team) {
            EffortTeamData.this.team = team;
            return this;
        }

        public EffortTeamData build() {
            return EffortTeamData.this;
        }
    }
}
