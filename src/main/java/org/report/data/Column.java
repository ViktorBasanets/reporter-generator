package org.report.data;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Column {
    ISSUE_KEY("Issue key", 0),
    ISSUE_ID("Issue id", 1),
    PARENT_ID("Parent id", 2),
    SUMMARY("Summary", 3),
    STATUS("Status", 4),
    ISSUE_TYPE("Issue Type", 5),
    ORIGINAL_ESTIMATE("Original Estimate", 6),
    PRIORITY("Priority", 7),
    TEAM_INPUT("Team", 8),
    TEAM_EFFORT("Team", 0),
    TOTAL_EFFORT("Total Effort", 1),
    REMAINING_EFFORT("Remaining Effort", 2);

    private final String canonicalName;

    private final int sequentialNumber;

    Column(String canonicalName, int sequentialNumber) {
        this.canonicalName = canonicalName;
        this.sequentialNumber = sequentialNumber;
    }

    public String canonicalName() {
        return canonicalName;
    }

    public int sequentialNumber() {
        return sequentialNumber;
    }

    public static String toRow(Column... columns) {
        return Arrays.stream(columns)
            .map(Column::canonicalName)
            .collect(Collectors.joining(", "));
    }
}
