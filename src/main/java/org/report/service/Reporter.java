package org.report.service;

import org.report.data.Team;

public interface Reporter<T, R> {

    void addRow(T row);

    R createReport(Team team);
}
