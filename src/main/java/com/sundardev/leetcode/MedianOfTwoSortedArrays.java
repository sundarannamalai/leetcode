package com.sundardev.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        assertSolution(new int[] {1, 3}, new int[] {2}, 2.0d);
        assertSolution(new int[] {1, 2}, new int[] {3, 4}, 2.5d);
        assertSolution(new int[] {1, 2}, new int[] {}, 1.5d);
        assertSolution(new int[] {1, 2}, new int[] {3, 4, 6}, 3.0d);
        assertSolution(new int[] {0, 0}, new int[] {0, 0}, 0.0d);
        assertSolution(new int[] {2}, new int[] {}, 2.0d);
    }

    private static void assertSolution(int[] nums1, int[] nums2, double expected)
    {
        Solution solution = new Solution();
        if (Double.compare(expected, solution.findMedianSortedArrays(nums1, nums2)) != 0) {
            System.out.println("Solution failed for input. nums1 = " + Arrays.asList(nums1) + ", nums2 = " + Arrays.asList(nums2));
            throw new RuntimeException("Solution failed");
        }
    }

    private static
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int totalNums = nums1.length + nums2.length;
            boolean evenLength = totalNums % 2 == 0;
            int medianPosition = totalNums / 2;
            medianPosition -= evenLength ? 1 : 0;
            int position = 0;
            int nums1Idx = 0, nums2Idx = 0;
            while ((nums1Idx < nums1.length && nums2Idx < nums2.length) && (position < medianPosition)) {
                if (nums1[nums1Idx] < nums2[nums2Idx]) {
                    nums1Idx++;
                } else {
                    nums2Idx++;
                }
                position++;
            }
            for (;(nums1Idx < nums1.length) && (position < medianPosition); nums1Idx++, position++);
            for (;(nums2Idx < nums2.length) && (position < medianPosition); nums2Idx++, position++);
            double median = 0;
            if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                if (nums1[nums1Idx] < nums2[nums2Idx]) {
                    median = nums1[nums1Idx++];
                } else {
                    median = nums2[nums2Idx++];
                }
            } else if (nums1Idx < nums1.length) {
                median = nums1[nums1Idx++];
            } else {
                median = nums2[nums2Idx++];
            }
            if (evenLength) {
                if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                    median = (median + Math.min(nums1[nums1Idx], nums2[nums2Idx])) / 2;
                } else if (nums1Idx < nums1.length) {
                    median = (median + nums1[nums1Idx]) / 2;
                } else {
                    median = (median + nums2[nums2Idx]) / 2;
                }
            }
            return median;
        }
    }
}
