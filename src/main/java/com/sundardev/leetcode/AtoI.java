package com.sundardev.leetcode;

public class AtoI {

    public static void main(String[] args) {
        assertSolution("42", 42);
        assertSolution("-42", -42);
        assertSolution("abcd", 0);
        assertSolution("4193 with words", 4193);
        assertSolution("words and 987", 0);
        assertSolution("     ", 0);
        assertSolution("-91283472332", -2147483648);
    }

    private static void assertSolution(String input, int expected) {
        Solution solution = new Solution();
        int actual = solution.myAtoi(input);
        if (expected != actual) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution
    {
        public int myAtoi(String s) {
            char[] chars = s.toCharArray();
            int value = 0;
            int pos = 0;
            for (;pos < s.length() && chars[pos] == ' ';pos++);
            boolean negativeSign = false;
            if (pos < s.length() && (chars[pos] == '+' || chars[pos] == '-')) {
                negativeSign = chars[pos] != '+' && (chars[pos] == '-');
                pos++;
            }
            for(;pos < s.length();pos++) {
                int chValue = (int) chars[pos];
                if (chValue < 48 || chValue > 57) {
                    //not a digit
                    break;
                }
                int newValue = value * 10 + (chValue - 48);
                if (newValue / 10 != value) {
                    return negativeSign ? Math.abs(Integer.MIN_VALUE) : Integer.MAX_VALUE;
                }
                value = newValue;
            }
            return negativeSign ? -value : value;
        }
    }
}
