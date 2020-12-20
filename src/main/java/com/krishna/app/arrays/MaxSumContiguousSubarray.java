package com.krishna.app.arrays;

public class MaxSumContiguousSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        return 0;
    }
}
