package com.krishna.app.hr;
import java.util.HashMap;
import java.util.Map;

public class FindPair {
    public void findParis(int arr[]) {
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        for(int i =0; i < arr.length; i++) {
            for(int j=i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(!map.containsKey(sum)) {
                    map.put(sum, new Pair(arr[i], arr[j]));
                } else {
                    Pair pair = map.get(sum);
                    System.out.println(arr[i]+","+ arr[j] +","+ pair.a+","+ pair.b);
                }
            }
        }
    }

    class Pair {
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FindPair findPair = new FindPair();
        int arr[] = new int[1000];
        for(int i =0; i < 1000; i++) {
            arr[i] = i;
        }
        findPair.findParis(arr);
    }
}