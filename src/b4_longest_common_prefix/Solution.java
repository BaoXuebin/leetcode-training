package b4_longest_common_prefix;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 *
 * @author BaoXuebin
 * @since 2021/7/13
 */
public class Solution {

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        String[] notMatchWords = {"dog", "racecar", "car"};
        System.out.println(new Solution().getLongestCommonPrefix(words));
        System.out.println(new Solution().getLongestCommonPrefix(notMatchWords));
    }

    private String getLongestCommonPrefix(String[] words) {
        // get the shortest word
        String prefix = words[0];
        for (int i = 1, l = words.length; i < l; i++) {
            if (prefix.length() > words[i].length()) {
                prefix = words[i];
            }
        }

        while (prefix.length() > 0) {
            if (isLongestCommonPrefix(prefix, words)) {
                return prefix;
            }
            prefix = prefix.substring(0, prefix.length() - 1);
        }

        return "";
    }

    private boolean isLongestCommonPrefix(String prefix, String[] words) {
        for (String word : words) {
            if (!word.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

}
