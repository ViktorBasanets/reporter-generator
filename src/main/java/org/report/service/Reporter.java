package org.report.service;

import java.util.List;

public interface Reporter<T, R> {
    List<R> reports(List<List<T>> data);
}
