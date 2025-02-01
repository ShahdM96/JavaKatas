package katas.exercises;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LagsTest {

    @Test
    void testExampleCase() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 3, 7, 80));
        requests.add(new Lags.Request("REQ03", 5, 4, 60));
        requests.add(new Lags.Request("REQ04", 6, 3, 70));

        int result = Lags.maximizeProfit(requests);
        assertEquals(120, result, "Expected maximum profit: 120");
    }

    @Test
    void testAllNonOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 2, 30));
        requests.add(new Lags.Request("REQ02", 3, 2, 40));
        requests.add(new Lags.Request("REQ03", 6, 3, 50));

        int result = Lags.maximizeProfit(requests);
        assertEquals(120, result, "Expected profit: 30+40+50=120");
    }

    @Test
    void testAllOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 1, 6, 70));
        requests.add(new Lags.Request("REQ03", 2, 7, 90));

        int result = Lags.maximizeProfit(requests);
        assertEquals(90, result, "Expected maximum profit: 90 (best single request)");
    }

    @Test
    void testEmptyList() {
        List<Lags.Request> requests = new ArrayList<>();
        int result = Lags.maximizeProfit(requests);
        assertEquals(0, result, "Expected maximum profit: 0 for empty list");
    }

    @Test
    void testSingleRequest() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 75));

        int result = Lags.maximizeProfit(requests);
        assertEquals(75, result, "Expected profit: 75 for a single request");
    }

    @Test
    void testMultipleOverlappingRequestsWithDifferentProfits() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 3, 40));
        requests.add(new Lags.Request("REQ02", 2, 3, 50));
        requests.add(new Lags.Request("REQ03", 4, 3, 80));
        requests.add(new Lags.Request("REQ04", 5, 3, 60));

        int result = Lags.maximizeProfit(requests);
        assertEquals(120, result, "Expected profit: 40 + 80 = 120");
    }
}

