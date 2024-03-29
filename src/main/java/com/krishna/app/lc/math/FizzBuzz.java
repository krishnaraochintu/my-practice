package com.krishna.app.lc.math;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for(int num= 1; num< n; num++) {
            boolean divisibleBy3 = num % 3 == 0;
            boolean divisibleBy5 = num % 5 == 0;
            String numAnsStr = "";
            if (divisibleBy3) {
                // Divides by 3, add Fizz
                numAnsStr += "Fizz";
            }

            if (divisibleBy5) {
                // Divides by 5, add Buzz
                numAnsStr += "Buzz";
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }
            list.add(numAnsStr);
        }
        return list;
    }
}
