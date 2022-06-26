package org.report.service;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseReport<T, R> implements Reporter<T, R> {

    protected final List<T> data;

    protected BaseReport() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addRow(T row) {
        data.add(row);
    }
}
