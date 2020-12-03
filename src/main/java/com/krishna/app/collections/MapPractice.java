package com.krishna.app.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Testing Thread");
            }
        }).start();
        new Thread(() -> {System.out.println("Testing Thread");} ).start();
        Square s = new Square() {
            @Override
            public int calculate(int x) {
                return x * x;
            }
        };
        Square square = (int x) -> x * x;
        square.calculate(4);*/
        String test = new String("testing two");
        System.out.println(test.hashCode());

    }

    public void test(Map<String, String> map) {
        for(String key : map.keySet()) {

        }
        for(String key : map.values()) {

        }
        for(Map.Entry<String, String> entry : map.entrySet()) {
          String output =   entry.getKey() + entry.getValue();
        }

    }
}
