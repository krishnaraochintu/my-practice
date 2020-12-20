package com.krishna.app.arrays;

import java.util.ArrayList;

public class MaximumSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> inputArray) {
        ArrayList<Integer> maxArray = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();
        int max_sum = 0;
        int new_sum = 0;
        for(int i=0; i < inputArray.size(); i++) {
            if(inputArray.get(i) >= 0) {
                new_sum = new_sum + inputArray.get(i);
                newArray.add(inputArray.get(i));
            } else {
                new_sum = 0;
                newArray = new ArrayList<>();
            }
            if(new_sum > max_sum || (new_sum == max_sum && newArray.size() > maxArray.size())) {
                max_sum = new_sum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
