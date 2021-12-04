package com.sundardev.leetcode;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ZigZagConversion {

    public static void main(String[] args)
    {
        assertSolution("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        assertSolution("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        assertSolution("PAYPALISHIRING", 5, "PHASIYIRPLIGAN");
        assertSolution("A", 1, "A");
        assertSolution("ABCDE", 4, "ABCED");
        assertSolution("AB", 1, "AB");
    }

    private static void assertSolution(String input, int numRows, String expected)
    {
        Solution solution = new Solution();
        String actual = solution.convert(input, numRows);
        if (!expected.equals(actual)) {
            throw new RuntimeException(String.format("Solution failed for input %s. Expected = %s, Actual = %s", input, expected, actual));
        }
    }

    private static
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder[] zigzagString = new StringBuilder[numRows];
            IntStream.range(0, numRows).forEach(rowNo -> {
                zigzagString[rowNo] = new StringBuilder();
            });
            int rowNum = 0;
            int strPos = 0;
            while (strPos < s.length()) {
                zigzagString[rowNum].append(s.charAt(strPos++));
                if (rowNum == (numRows - 1)) {
                    while(rowNum > 0 && strPos < s.length()) {
                        zigzagString[--rowNum].append(s.charAt(strPos++));
                    }
                }
                rowNum++;
            }
            StringBuilder converted = new StringBuilder();
            Stream.of(zigzagString).forEach(converted::append);
            return converted.toString();
        }
    }
}

