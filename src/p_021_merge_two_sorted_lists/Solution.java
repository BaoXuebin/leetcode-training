package p_021_merge_two_sorted_lists;

/**
 * @author ：BaoXuebin
 * Date: Created at 2019/9/1 22:35
 *
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 */
public class Solution {

    /**
     * Runtime: 100.00% 0 ms
     * Memory Usage: 17.17% 39.4 MB
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1      2   3
        // 2      3   4    5  6
        // first  repeat  rest

        // 异常处理
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result;
        ListNode cursor;

        // 确定第一个节点
        if (l1.val < l2.val) {
            cursor = l1;
            result = cursor;
            l1 = l1.next;
        } else {
            cursor = l2;
            result = cursor;
            l2 = l2.next;
        }

        // 循环之后重叠的节点
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }

        // 遍历添加多余的节点
        ListNode rest = l1 != null ? l1 : l2;
        while (rest != null) {
            cursor.next = rest;
            rest = rest.next;
            cursor = cursor.next;
        }

        return result;
    }

    /**
     * 链表需要构建一个虚拟的头部节点，才能方便实现其他节点的循环遍历
     *
     * Runtime: 100.00% 0 ms
     * Memory Usage: 17.17% 39.4 MB
     */
public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode virtualHead = new ListNode(-1);
    ListNode node = virtualHead;

    while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        } else {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
    }

    node.next = l1 != null ? l1 : l2;

    return virtualHead.next;
}

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a2.next = new ListNode(3);
        a1.next = a2;

        System.out.println(a1);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        b2.next = new ListNode(4);
        b1.next = b2;

        System.out.println(b1);

        System.out.println(s.mergeTwoLists(null, b1));
        System.out.println(s.mergeTwoLists2(null, b1));
    }

}
