package com.sundardev.leetcode;

public class IntegerToRoman {

    public static void main(String[] args) {
        assertSolution(1, "I");
        assertSolution(12, "XII");
        assertSolution(14, "XIV");
        assertSolution(212, "CCXII");
        assertSolution(99, "XCIX");
        assertSolution(58, "LVIII");
        assertSolution(1994, "MCMXCIV");
        assertSolution(9, "IX");
        assertSolution(4, "IV");
        assertSolution(3, "III");
    }

    private static void assertSolution(int input, String expected) {
        Solution solution = new Solution();
        String actual = solution.intToRoman(input);
        if (!expected.equals(actual)) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution
    {
        public String intToRoman(int num) {
            StringBuilder roman = new StringBuilder();
            while (num > 0) {
                if (num >= 1000) {
                    roman.append("M");
                    num -= 1000;
                } else if (num >= 900) {
                    roman.append("CM");
                    num -= 900;
                } else if (num >= 500) {
                    roman.append("D");
                    num -= 500;
                } else if (num >= 400) {
                    roman.append("CD");
                    num -= 400;
                } else if (num >= 100) {
                    roman.append("C");
                    num -= 100;
                } else if (num >= 90) {
                    roman.append("XC");
                    num -= 90;
                } else if (num >= 50) {
                    roman.append("L");
                    num -= 50;
                } else if (num >= 40) {
                    roman.append("XL");
                    num -= 40;
                } else if (num >= 10) {
                    roman.append("X");
                    num -= 10;
                } else if (num >= 9) {
                    roman.append("IX");
                    num -= 9;
                } else if (num >= 5) {
                    roman.append("V");
                    num -= 5;
                } else if (num >= 4) {
                    roman.append("IV");
                    num -= 4;
                } else {
                    roman.append("I");
                    num -= 1;
                }
            }
            return roman.toString();
        }
    }
}
