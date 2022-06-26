package org.report.data;

public enum Team {
    UI("UI"),
    LONDON("London"),
    NY("NY"),
    KYIV("Kiev"),
    INDIA("India");

    Team(String value) {
        this.value = value;
    }

    private final String value;

    public String value() {
        return value;
    }
}
