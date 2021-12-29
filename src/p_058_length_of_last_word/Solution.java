package p_058_length_of_last_word;

/**
 * 58. Length of Last Word
 *
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 *
 * @author BaoXuebin
 * @since 2021/12/29
 */
public class Solution {

    private int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len ++;
            } else if (len != 0) {
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("a"));
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new Solution().lengthOfLastWord("luffy is still joyboy"));
    }

}
