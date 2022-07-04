package org.report.service;

import java.util.List;

public interface Mapper<T> {
    List<List<T>> mapBy(List<T> data);
}
