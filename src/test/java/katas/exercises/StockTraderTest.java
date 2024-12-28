package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTraderTest {
    @Test
    public void testMaxProfit() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int expected =StockTrader.maxProfit(stockPrices);
        assertEquals(5,expected);
    }
}
