package com.sundardev.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.twoSum(new int[] {2, 7, 11, 15}, 9), 0, 1);
        assertThat(solution.twoSum(new int[] {3, 2, 4}, 6), 1, 2);
        assertThat(solution.twoSum(new int[] {3, 3}, 6), 0, 1);
        assertThat(solution.twoSum(new int[] {-3, 3, 1, 2}, -2), 0, 2);
    }

    private static void assertThat(int[] result, int expectedIndex1, int expectedIndex2) {
        assert ((result[0] == expectedIndex1 && result[1] == expectedIndex2) || (result[0] == expectedIndex2 && result[1] == expectedIndex1));
    }
}


class Solution {
    public int[] twoSum(final int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(100);
        for(int index = 0;index < nums.length; index++) {
            final int num = nums[index];
            if (numIndexMap.containsKey(target - num)) {
                return new int[] {numIndexMap.get(target - num), index};
            }
            numIndexMap.put(num, index);
        }
        throw new RuntimeException("Solution not found");
    }
}