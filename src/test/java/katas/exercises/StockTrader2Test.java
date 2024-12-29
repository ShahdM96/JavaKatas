package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTrader2Test {
    @Test
    public void testMaxProfit(){
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int result =StockTrader2.maxProfit(stockPrices);
        assertEquals(7,result);


    }
}
