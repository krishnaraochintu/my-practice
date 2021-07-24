package com.krishna.app.lc;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    static  HashMap<Character, Character> mappings = new HashMap<Character, Character>();
    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        // Using ArrayDeque is faster than using Stack class
       // Deque<Character> stack = new ArrayDeque<Character>();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(mappings.containsKey(c)) { // We got Closed Bracket
                char lastCharInStack = stack.isEmpty() ? '#' : stack.pop();
                if(lastCharInStack != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "([{}])";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(expr));
    }
}

