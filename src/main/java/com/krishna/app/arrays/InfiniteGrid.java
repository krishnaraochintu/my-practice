package com.krishna.app.arrays;

import java.util.ArrayList;

public class InfiniteGrid {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int numberOfSteps = 0;
        for(int i = 0; i < A.size(); i++) {
            numberOfSteps += Math.max(Math.abs(A.get(i) - A.get(i-1)), Math.abs(B.get(i) - B.get(i-1)));
        }
        return numberOfSteps;
    }
}
