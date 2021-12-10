package com.sundardev.leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        assertSolution(121, true);
        assertSolution(-121, false);
        assertSolution(12, false);
        assertSolution(-101, false);
        assertSolution(1221, true);
        assertSolution(12533521, true);
        assertSolution(100001, true);
        assertSolution(1000021, false);
    }

    private static void assertSolution(int input, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.isPalindrome(input);
        if (expected != actual) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            boolean palindrome = true;
            int divideBy = 1;
            int value = x;
            while (value > 9) {
                divideBy *= 10;
                value /= 10;
            }
            value = x;
            int modulo = 10;
            while (divideBy >= modulo && palindrome) {
                palindrome = ((value / divideBy) % 10) == ((value % modulo)/(modulo / 10));
                divideBy /= 10;
                modulo *= 10;
            }
            return palindrome;
        }
    }
}
