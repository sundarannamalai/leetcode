package com.sundardev.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        assertSolution("babad", "bab");
        assertSolution("cbbd", "bb");
        assertSolution("a", "a");
        assertSolution("ac", "a");
        assertSolution("abccbaabccb", "bccbaabccb");
        assertSolution("abcabcdefedcba", "abcdefedcba");
        assertSolution("abbaabbaccabbaa", "aabbaccabbaa");
        assertSolution("ccc", "ccc");
        assertSolution("bb", "bb");
        assertSolution("aaabb", "aaa");
        assertSolution("abb", "bb");
        assertSolution("aaaa", "aaaa");
    }

    private static void assertSolution(String input, String expected) {
        Solution solution = new Solution();
        String actual = solution.longestPalindrome(input);
        if (!expected.equals(actual)) {
            throw new RuntimeException("Solution failed for input " + input + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution {
        public String longestPalindrome(String input) {
            char[] chars = input.toCharArray();
            int length = chars.length;
            int longestPalindromicSubStrSt = 0;
            int longestPalindromicSubStrEnd = 0;
            int palindromicSubStrSt = 0;
            int palindromicSubStrEnd;
            int st = 0;
            while (st < length) {
                int end = st;
                palindromicSubStrSt = st;
                while (end < length) {
                    int validationSt = st;
                    int validationEnd = end;
                    while(chars[validationSt] == chars[validationEnd] && validationSt++ < validationEnd--);
                    if (validationSt >= validationEnd) {
                        palindromicSubStrEnd = end;
                        if ((palindromicSubStrEnd  - palindromicSubStrSt) > (longestPalindromicSubStrEnd - longestPalindromicSubStrSt)) {
                            longestPalindromicSubStrSt = palindromicSubStrSt;
                            longestPalindromicSubStrEnd = palindromicSubStrEnd;
                        }
                    }
                    end++;
                }
                st++;
            }
            return input.substring(longestPalindromicSubStrSt, longestPalindromicSubStrEnd + 1);
        }


    }
}
