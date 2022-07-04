package org.report.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.report.data.Team;

public class EffortTeamDataAdapterTest {

    @Test
    void checkAdaptMethod_teamPresented_shouldReturnListOfData() {
        var testHeader = new String[]{"c1", "c2", "c3", "c4", "Status", "c6", "Original Estimate", "c8", "Team"};
        var testLine1 = new String[]{"xxx1", "xxx2", "xxx3", "xxx4", "Open", "xxx6", "28800", "xxx8", "London"};
        var testLines = List.of(testHeader, testLine1);

        var testAdapter = new EffortTeamAdapter();
        var actualResult = testAdapter.adapt(testLines);

        assertEquals(1, actualResult.size());
        assertEquals("Open", actualResult.get(0).getStatus());
        assertEquals(28800L, actualResult.get(0).getOriginalEstimate());
        assertEquals("London", actualResult.get(0).getTeam());
    }

    @Test
    void checkAdaptMethod_teamPresentedListOnlyWithTitle_shouldReturnEmptyList() {
        var testHeader = new String[]{"c1", "c2", "c3", "c4", "Status", "c6", "Original Estimate", "c8", "Team"};
        var testLine1 = new String[]{};
        var testLines = List.of(testHeader, testLine1);

        var testAdapter = new EffortTeamAdapter();
        var actualResult = testAdapter.adapt(testLines);

        assertEquals(0, actualResult.size());
    }

    @Test
    void checkAdaptMethod_teamNotEquals_shouldReturnEmptyList() {
        var testHeader = new String[]{"c1", "c2", "c3", "c4", "Status", "c6", "Original Estimate", "c8", "Team"};
        var testLine1 = new String[]{"xxx1", "xxx2", "xxx3", "xxx4", "Open", "xxx6", "28800", "xxx8", "London"};
        var testLines = List.of(testHeader, testLine1);

        var testAdapter = new EffortTeamAdapter();
        var actualResult = testAdapter.adapt(testLines);

        assertEquals(1, actualResult.size());
    }
}
