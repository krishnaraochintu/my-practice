package com.krishna.app.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFaltMap {
    public static void main(String[] args) {

        List<Integer> numbersList = Arrays.asList(12, 45, 67, 19, 87, 2, 9);
        numbersList.stream().map(integer -> integer * 2).forEach(System.out::println);
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String> productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");
        List<List<String>> allproducts = new ArrayList<List<String>>();
        allproducts.add(productlist1);
        allproducts.add(productlist2);
        allproducts.add(productlist3);
        allproducts.add(productlist4);
        List<String> listOfAllProducts = new ArrayList<String>();
        for (List<String> pro : allproducts) {
            for (String product : pro) {
                listOfAllProducts.add(product);
            }
        }
        allproducts.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
        allproducts.stream().collect(Collectors.toList());
    }
}
