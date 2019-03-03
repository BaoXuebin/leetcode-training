package a3_longest_substring_without_repeating_characters;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/3 20:12
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Runtime: 92.67%  20 ms
 * Memory Usage: 11.69%  40.2 MB
 *
 */
public class Solution {

    private int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int index = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, l = chars.length; i < l; i++) {
            if (map.containsKey(chars[i])) {
                index = Math.max(index, map.get(chars[i]));
            }
            map.put(chars[i], i);
            max = Math.max(max, i - index);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abba") == 2);
        System.out.println(s.lengthOfLongestSubstring(" ") == 1);
        System.out.println(s.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(s.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(s.lengthOfLongestSubstring("pwwkew") == 3);
    }

}
