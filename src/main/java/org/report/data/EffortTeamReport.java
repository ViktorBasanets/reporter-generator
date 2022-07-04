package org.report.data;

public class EffortTeamReport {

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

        public Builder totalEffort(double totalEffort) {
            EffortTeamReport.this.totalEffort = totalEffort;
            return this;
        }

        public Builder remainingEffort(double remainingEffort) {
            EffortTeamReport.this.remainingEffort = remainingEffort;
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
