package com.sundardev.leetcode;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        assertSolution(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49);
        assertSolution(new int[] {1, 1}, 1);
        assertSolution(new int[] {4, 3, 2, 1, 4}, 16);
        assertSolution(new int[] {1, 2, 1}, 2);
    }

    private static void assertSolution(int[] input, int expected) {
        Solution solution = new Solution();
        int actual = solution.maxArea(input);
        if (expected != actual) {
            throw new RuntimeException("Solution failed for input " + Arrays.toString(input) + ", Expected : " + expected + ", Actual = " + actual);
        }
    }

    private static
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
                if(height[left] < height[right]) {
                    left = left + 1;
                } else {
                    right = right - 1;
                }
            }
            return maxArea;
        }
    }
}
