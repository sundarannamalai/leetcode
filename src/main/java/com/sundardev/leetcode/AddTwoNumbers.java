package com.sundardev.leetcode;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.addTwoNumbers(createFor(new int[]{2, 4, 3}), createFor(new int[]{5, 6, 4})), new int[]{7, 0, 8});
        assertThat(solution.addTwoNumbers(createFor(new int[]{1, 7, 3}), createFor(new int[]{6, 4, 8})), new int[]{7, 1, 2, 1});
        assertThat(solution.addTwoNumbers(createFor(new int[]{1, 8}), createFor(new int[]{9, 5, 6, 4})), new int[]{0, 4, 7, 4});
        System.out.println("Test Successful");
    }

    private static ListNode createFor(int[] integers) {
        ListNode startNode = new ListNode();
        ListNode prev = null;
        ListNode cur = startNode;
        for (int integer : integers) {
            cur.val = integer;
            if (prev != null) {
                prev.next = cur;
            }
            prev = cur;
            cur = new ListNode();
        }
        return startNode;
    }

    private static void assertThat(ListNode result, int[] integers) {
        for (int integer : integers) {
            //compare each number
            assert result.val == integer;
            result = result.next;
        }
        //ensure entire list is covered.
        if(result != null) {
            throw new RuntimeException("Test failed.");
        }
    }

    private static
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode cur = result;
            ListNode prev = null;
            int carry = 0;
            int num1, num2;
            while (l1 != null || l2 != null || carry != 0) {
                if (prev != null) {
                    prev.next = cur;
                }
                num1 = 0;
                num2 = 0;
                if (l1 != null) {
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    num2 = l2.val;
                    l2 = l2.next;
                }
                cur.val = (carry + num1 + num2) % 10;
                carry = (carry + num1 + num2) / 10;
                prev = cur;
                cur = new ListNode();
            }
            return result;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
