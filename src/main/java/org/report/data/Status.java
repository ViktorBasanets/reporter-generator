package org.report.data;

public enum Status {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    CLOSED_COMPLETE("Closed - Complete"),
    CLOSED_REJECTED("Closed - Rejected");

    Status(String value) {
        this.value = value;
    }

    private final String value;

    public String value() {
        return value;
    }
}
