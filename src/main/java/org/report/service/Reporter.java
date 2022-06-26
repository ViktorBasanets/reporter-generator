package org.report.service;

public interface Reporter<T, R> {

    void addRow(T row);

    R createReport();
}
