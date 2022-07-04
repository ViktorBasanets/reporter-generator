package org.report.service;

import java.util.List;

public interface Adapter<T, R> {
    List<R> adapt(List<T> lines);
}
