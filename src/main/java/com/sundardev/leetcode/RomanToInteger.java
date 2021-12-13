package com.sundardev.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        assertSolution("III", 3);
        assertSolution("IV", 4);
        assertSolution("IX", 9);
        assertSolution("LVIII", 58);
        assertSolution("MCMXCIV", 1994);
    }

    private static void assertSolution(String input, int expected) {
        Solution solution = new Solution();
        int actual = solution.romanToInt(input);
        if (expected != actual) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution {
        private static final Map<Character, Integer> romanToInteger = new HashMap<>();
        static {
            romanToInteger.put('I', 1);
            romanToInteger.put('V', 5);
            romanToInteger.put('X', 10);
            romanToInteger.put('L', 50);
            romanToInteger.put('C', 100);
            romanToInteger.put('D', 500);
            romanToInteger.put('M', 1000);
        }

        public int romanToInt(String s) {
            int prevValue = 0;
            int value = 0;
            for (int pos = s.length() - 1; pos >= 0; pos--) {
                int currValue = romanToInteger.get(s.charAt(pos));
                if (currValue < prevValue) {
                    currValue = -currValue;
                }
                value += currValue;
                prevValue = currValue;
            }
            return value;
        }
    }
}
