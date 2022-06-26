package org.report.service;

import java.util.List;

public interface DataAdapter<T> {
    List<T> adapt(List<String[]> lines);
}
