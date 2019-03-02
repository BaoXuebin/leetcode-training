package a2_add_two_numbers;

/**
 * 2. Add Two Numbers
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/1 21:09
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @link: https://xdbin.com/blog/8a9eec516934916e01693a20d6e70000
 */

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            if (next == null) return "" + val;
            return val + ", " + next.toString();
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    private ListNode textCase(int ...nums) {
        ListNode node = null;
        ListNode first = null;
        for (int i = 0, l = nums.length; i < l; i ++) {
            if (first == null) {
                first = new ListNode(nums[i]);
                node = first;
            } else {
                node.next = new ListNode(nums[i]);
                node = node.next;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addTwoNumbers(s.textCase(8, 9, 9), s.textCase(2)));
        System.out.println(s.addTwoNumbers(s.textCase(5), s.textCase(5)));
    }

}
