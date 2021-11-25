package com.krishna.app;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StringTesting {
    public static void main(String[] args) {
        ArrayList<String> tags
                = new ArrayList<String>();

        // Adding elements to above ArrayList
        // using add() method
        tags.add("welcome");
        /*geeklist.add("to");
        geeklist.add("geeks");
        geeklist.add("for");
        geeklist.add("geeks");*/

        // collect() method returns the result of the
        // intermediate operations performed on the stream
        String str = tags.stream().collect(Collectors.joining(","));

        // Printing the comma separated string
        System.out.println(str);
    }
}
