package com.krishna.app.lc;

public class CoinChangeProblem {
    public long getNumberOfWays(long N, long[] Coins) {
        long[] ways = new long[(int) N + 1];//ways array
        ways[0] = 1;//Set the first way to 1 because its 0 and there is 1 way to make 0 with 0 coins
        for (int i = 0; i < Coins.length; i++) {
            // Make a comparison to each index value of ways with the coin value.
            for (int j = 0; j < ways.length; j++) {
                if (Coins[i] <= j) {
                    ways[j] += ways[(int) (j - Coins[i])]; // Update the ways array
                }
            }
        }
        return ways[(int)N];//return the value at the Nth position of the ways array.
    }
}
