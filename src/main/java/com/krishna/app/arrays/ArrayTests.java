package com.krishna.app.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTests {
    public static void main(String[] args) {
        MaxSumTriplet maxSumTriplet = new MaxSumTriplet();
        //ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 32392, 14605,5437));
        ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(2,5,3,1,4,6,9,7));
        System.out.println(maxSumTriplet.solve(integers));
    }
}
