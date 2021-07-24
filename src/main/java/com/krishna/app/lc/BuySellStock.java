package com.krishna.app.lc;

public class BuySellStock {
    static int maxProfit(int price[], int n)
    {
        // Create profit array
        // and initialize it as 0
        int profit[] = new int[n];
        for (int i = 0; i < n; i++)
            profit[i] = 0;

        /* Get the maximum profit
           with only one transaction
           allowed. After this loop,
           profit[i] contains
           maximum profit from
           price[i..n-1] using at most
           one trans. */
        int max_price = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // max_price has maximum
            // of price[i..n-1]
            if (price[i] > max_price)
                max_price = price[i];

            // we can get profit[i]
            // by taking maximum of:
            // a) previous maximum,
            // i.e., profit[i+1]
            // b) profit by buying
            // at price[i] and selling
            // at
            //    max_price
            profit[i] = Math.max(profit[i + 1],
                    max_price - price[i]);
        }

        /* Get the maximum profit
           with two transactions allowed
           After this loop, profit[n-1]
           contains the result
         */
        int min_price = price[0];
        for (int i = 1; i < n; i++) {
            // min_price is minimum
            // price in price[0..i]
            if (price[i] < min_price)
                min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
            profit[i] = Math.max(
                    profit[i - 1],
                    profit[i] + (price[i] - min_price));
        }
        int result = profit[n - 1];
        return result;
    }

    static int maxProfitValleyPeak(int price[], int n) {
        int profit = 0;
        for(int i = 1; i < n; i++) {
            int sub = price[i] - price[i-1];
            if(sub > 0) {
                profit += sub;
            }
        }
        return profit;
    }
   //OneTime Buy and Sell
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    //OneTime Buy and Sell
    public int maxProfitOnePass(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0 ; i< prices.length; i++) {
            if(prices[i] < minprice) {
                minprice = prices[i];
            } else if((prices[i] - minprice) > maxProfit) {
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }

    public static void main(String args[])
    {
        int price[] = { 10, 22, 5, 75, 65, 80 };
        int n = price.length;
        System.out.println("Maximum Profit = "
                + maxProfitValleyPeak(price, n));
    }
}
