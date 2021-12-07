package com.sundardev.leetcode;

public class ReverseInt {

    public static void main(String[] args) {
        assertSolution(123, 321);
        assertSolution(-123, -321);
        assertSolution(120, 21);
        assertSolution(504, 405);
        assertSolution(0, 0);
        assertSolution(9, 9);
        assertSolution(91, 19);
        assertSolution(2147483647, 0);
        assertSolution(1534236469, 0);
        assertSolution(800091239, 932190008);
    }

    private static void assertSolution(int input, int expected) {
        Solution solution = new Solution();
        int actual = solution.reverse(input);
        if (expected != actual) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution
    {
        public int reverse(int x) {
            boolean negative = x < 0;
            x = Math.abs(x);
            int reversed = recursiveReverse(x, 0);
            return negative ? -reversed : reversed;
        }

        int recursiveReverse(int x, int newValue)
        {
            if (x < 10) {
                int returnValue = newValue * 10 + x;
                if ((returnValue / 10) != newValue) {
                    return 0;
                }
                return returnValue;
            }
            return recursiveReverse(x / 10, newValue * 10 + (x % 10));
        }
    }
}
