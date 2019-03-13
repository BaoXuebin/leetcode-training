package a5_longest_palindromic_substring;

/**
 * 5. Longest Palindromic Substring
 *
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/13 20:59
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Runtime: 55.90%  27 ms
 * Memory Usage: 89.52%  37.6 MB
 */
public class Solution {


    /**
     * First Solution.
     */
    private String longestPalindrome(String s) {
        int max = 0, start = 0;
        if (s.length() < 2) return s;
        for (int i = 0, l = s.length(); i < l; i++) {
            if (l - i <= max / 2) {
                break;
            }
            int left = i, right = i;
            // cbbd 跳过重复的字符
            while (right < (l - 1) && s.charAt(right) == s.charAt(right + 1)) {
                right ++;
            }
            while (left >= 0 && right < l && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            // System.out.println(left + ", " + right + ", " + (right - left - 1));
            if ((right - left - 1) > max) {
                start = left + 1;
                max = right - left - 1;
                // System.out.println(start + ", " + max);
            }
        }
        // System.out.println(start + ", " + max);
        return s.substring(start, max + start);
    }

    /**
     * TODO: Manacher's Algorithm
     */

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

}
