package p_021_merge_two_sorted_lists;

/**
 * @author ：BaoXuebin
 * Date: Created at 2019/9/1 22:36
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : ("->" + next.toString()));
    }
}
