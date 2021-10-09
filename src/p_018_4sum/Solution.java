package p_018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Accepted
 *
 * @author BaoXuebin
 * @since 2021/7/17
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testCase1 = {1, 0, -1, 0, -2, 2};
        System.out.println(solution.fourSum(testCase1, 0));

        int[] testCase2 = {-499, -486, -479, -462, -456, -430, -415, -413, -399, -381, -353, -349, -342, -337, -336, -331, -330, -322, -315, -280, -271, -265, -249, -231, -226, -219, -216, -208, -206, -204, -188, -159, -144, -139, -123, -115, -99, -89, -80, -74, -61, -22, -22, -8, -5, 4, 43, 65, 82, 86, 95, 101, 103, 123, 149, 152, 162, 165, 168, 183, 204, 209, 209, 220, 235, 243, 243, 244, 248, 253, 260, 273, 281, 284, 288, 290, 346, 378, 382, 384, 407, 411, 423, 432, 433, 445, 470, 476, 497};
        System.out.println(solution.fourSum(testCase2, 3032));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

}
