package p_035_search_insert_position;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 * @author BaoXuebin
 * @since 2021/12/28
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6};
        System.out.println(new Solution().searchInsert(arr, 5));
        int[] arr2 = {1, 3, 5, 6};
        System.out.println(new Solution().searchInsert(arr2, 2));
        int[] arr3 = {1, 4, 5, 6};
        System.out.println(new Solution().searchInsert(arr3, 7));
    }

}
