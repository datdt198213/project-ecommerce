package com.dangdat.ecommerce.codeThieuNhi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character,Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            } else if(!stack.empty()) {
                Character pop = stack.pop();
                if(map.get(pop) != c)
                    return false;
            } else return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        boolean result = isValid("()[]{}");
        System.out.println("Result: " + result);
    }
}
