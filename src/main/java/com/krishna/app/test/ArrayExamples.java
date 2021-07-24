package com.krishna.app.test;

import java.util.Arrays;

public class ArrayExamples {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //int nums[] = {21,22,23,24,25,26,27};
        int prices[] = {9, 2, 7, 5, 8, 1,4};
        ArrayExamples arrayExamples = new ArrayExamples();
        arrayExamples.maxProfit(prices);
        //arrayExamples.rotateByReversing(nums, 3);
       /* ArrayExamples arrayExamples = new ArrayExamples();
        int nums[] = {25, 25, 25, 25, 26, 26, 27, 28,28};
        // int nums[] = {0,0,1,1,1,2,2,3,3,4};
        //int nums[] = {0,0,1,1,1,2,2,3,3,4,5,6,6,6,7,7,7};
        int length = arrayExamples.removeDuplicates2(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ",");
        }*/

    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int start = 0, end = 0, s = 0;
        for(int i = 0 ; i < nums.length; i++) {
            maxEndingHere += nums[i];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i +1;
            }
        }
        return maxSoFar;
    }
    public int robDP(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length -1];
    }

    public int robDPM(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int value1 = nums[0];
        int value2 = Math.max(nums[0], nums[1]);
        int maxProfit = 0;
        for(int i = 2; i < nums.length; i++) {
            maxProfit = Math.max(value1 + nums[i], value2);
            value1 = value2;
            value2 = maxProfit;
        }
        return maxProfit;
    }


    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int even = 0;
        int odd = 0;
        for(int i = 1; i < nums.length; i++) {
            if(i % 2 == 0) {
                even += nums[i];
                even = even > odd ? even : odd;
            } else {
                odd += nums[i];
                odd = even > odd ? even : odd;
            }
        }
        return even > odd ? even : odd;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        } else if (length == 2) {
            if (nums[0] == nums[1]) {
                return 1;
            } else {
                return 2;
            }
        }
        int previous = nums[0];
        for (int i = 1; i < length; i++) {
            int current = nums[i];
            if (previous == current) {
                for (int j = i; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                i = i - 1;
                length = length - 1;
            }
            previous = current;
        }
        return length;
    }

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int j = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j++] = nums[length - 1];
        return j;
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0 ; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitBF(int[] prices, int start, int end) {
        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (prices[j] > prices[i]) {
                    int curr_profit = prices[j] - prices[i]
                            + maxProfitBF(prices, start, i - 1)
                            + maxProfitBF(prices, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    public int maxProfitBF(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public void rotateBF(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public void rotateExtraArray(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        int newArray[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }

    public void rotateCR(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length <= 1) {
            return;
        }
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotateByReversing(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }


}
