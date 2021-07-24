package com.krishna.app.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class NikeTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String arrayString[] = line.split(",");
            Integer array[] = new Integer[arrayString.length];
            for(int i = 0; i < arrayString.length; i++) {
                int number = Integer.parseInt(arrayString[i]);
                array[i] = number;
            }
            findFourElementsSum(array);
        }
    }


    static public void findFourElementsSum(Integer array[]) {
        int length = array.length;
        int numberOfTimes = 0;
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        for(int i = 0 ; i < length - 1; i++) {
            for(int j = i+1; j <  length; j++) {
                map.put(array[i]+ array[j], new Pair(i,j));
            }
        }
        ArrayList<Set<Integer>> sumZeroList = new ArrayList<Set<Integer>>();

        for(int i = 0 ; i < length - 1; i++) {
            for(int j = i+1; j < length; j++) {
                int sum = array[i] + array[j];
                sum = sum * -1;
                if(map.containsKey(sum)) {
                    Pair pair = map.get(sum);
                    if(pair.first != i && pair.first != j && pair.second != i && pair.second != j) {
                        Set<Integer> sumZeroSet = new TreeSet<Integer>();
                        sumZeroSet.add(i);
                        sumZeroSet.add(j);
                        sumZeroSet.add(pair.first);
                        sumZeroSet.add(pair.second);
                        if(!sumZeroList.contains(sumZeroSet)) {
                            sumZeroList.add(sumZeroSet);
                            numberOfTimes++;
                        }
                    }
                }
            }
        }
        System.out.println(numberOfTimes);
    }

    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
