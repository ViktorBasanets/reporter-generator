package org.report.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.report.data.EffortTeamData;
import org.report.data.Team;

public class EffortTeamMapper implements Mapper<EffortTeamData> {

    @Override
    public List<List<EffortTeamData>> mapBy(List<EffortTeamData> listData) {
        return Arrays.stream(Team.values())
            .map(team -> listData.stream()
                .filter(data -> EffortTeamData.mapTo(data.getTeam()).equals(team))
                .collect(Collectors.toList()))
            .filter(dataList -> !dataList.isEmpty())
            .collect(Collectors.toList());
    }
}
