package com.krishna.app.test;

public class BlackHawk {
    //The cost of a stock on each day is given in an array,
    // find the max profit that you can make by buying and selling in those days.
    // For example, if the given array is {100, 180, 260, 310, 40, 535, 695}
    int maxProfit(int arr[]) {
        int max_profit = 0;
       for(int i= 0; i < arr.length; i++) {
           for(int j = i; j < arr.length; j++) {
               if(arr[j] - arr[i] > max_profit) {
                   max_profit = arr[j] - arr[i];
               }
           }
       }
       return max_profit;
    }

    int maxProfitSlidingWindow(int arr[]) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        for(int i= 0; i < arr.length; i++) {
           if(arr[i] < min_price) {
            
               min_price = arr[i];
           } else if((arr[i] - min_price) > max_profit) {
                max_profit = arr[i] - min_price;
           }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int arr[] = {100, 180, 260, 310, 695, 540, 40};
        BlackHawk blackHawk = new BlackHawk();
        int maxProfit = blackHawk.maxProfit(arr);
        System.out.println(maxProfit);
        int maxProfitSlidingWindow = blackHawk.maxProfitSlidingWindow(arr);
        System.out.println(maxProfitSlidingWindow);
    }
}
