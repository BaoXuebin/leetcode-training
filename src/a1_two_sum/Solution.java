package a1_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/2 22:41
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class Solution {

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0, l = nums.length; i < l; i++) {
            if (hashMap.keySet().contains(target - nums[i])) {
                return new int[]{ hashMap.get(target - nums[i]), i };
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[]{7, 21, 11, 2, 15}, 9);
        System.out.println(res[0] + ", " + res[1]);
    }
}
