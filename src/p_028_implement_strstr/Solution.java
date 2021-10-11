package p_028_implement_strstr;

/**
 * @author BaoXuebin
 * @since 2021/10/11
 *
 * 28. Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 *
 */
public class Solution {

    public static void main(String[] args) {
        // 这种题目有何意义
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
        System.out.println(new Solution().strStr("", ""));
        System.out.println(new Solution().strStr("1", "11"));
        System.out.println(new Solution().strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
//        if (needle == null || needle.length() == 0) {
//            return 0;
//        }

//        for (int i = 0, l = haystack.length(); i < l; i++) {
//            int idx = 0;
//            while ((i + idx) < l && haystack.charAt(i + idx) == needle.charAt(idx)) {
//                if (idx == needle.length() - 1) {
//                    return i;
//                }
//                idx ++;
//            }
//        }
//
//        return -1;
    }

}
