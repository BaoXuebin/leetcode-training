package p_024_swap_nodes_in_pairs;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 *
 * @author BaoXuebin
 * @since 2021/10/31
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode result = nextNode;
        int i = 0;
        while (nextNode != null) {
            if (i % 2 == 0) { // 偶数位和前一个交换
                head.next = nextNode.next;
                nextNode.next = head;
            } else if (nextNode.next != null) { // 奇数位有下一个节点，
                ListNode temp = head.next;
                head.next = nextNode.next;
                head = temp;
            } else {
                break;
            }
            nextNode = head.next;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        // 链表的移位需要考虑下一个节点的地址
    }

}
