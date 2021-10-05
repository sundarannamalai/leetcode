package com.sundardev.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        assertThat(0, "");
        assertThat(1, "a");
        assertThat(3, "abcabcbb");
        assertThat(3, "bacabcbb");
        assertThat(1, "bbbbb");
        assertThat(2, "bbbbba");
        assertThat(3, "pwwkew");
        assertThat(8, "abcdefgh");
        assertThat(8, "abcadefgh");
        System.out.println("Tests are successful");
    }

    private static void assertThat(int expected, String input) {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(input);
        if (expected != actual) {
           throw new RuntimeException("Test failed for input " + input + ", expected = " + expected + ", actual = " + actual);
        }
    }

    private static
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int subStringSt = 0, subStringEnd = 0;
            int longestSubstringLength = 0;
            while (subStringEnd < chars.length) {
                for(int subStringIdx = subStringSt; subStringIdx < subStringEnd; subStringIdx++) {
                    if (chars[subStringIdx] == chars[subStringEnd]) {
                        longestSubstringLength = Math.max((subStringEnd - subStringSt), longestSubstringLength);
                        subStringSt = subStringIdx + 1;
                        break;
                    }
                }
                subStringEnd++;
            }
            return Math.max((subStringEnd - subStringSt), longestSubstringLength);
        }
    }
}
