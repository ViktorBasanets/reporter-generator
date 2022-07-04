package org.report.service;

import java.util.List;
import org.report.data.Team;

public interface Adapter<L, T> {
    List<T> adapt(Team team, List<L> lines);
}
