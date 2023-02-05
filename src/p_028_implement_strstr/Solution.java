package p_028_implement_strstr;

import java.util.Objects;

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
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
        System.out.println(new Solution().strStr("", ""));
        System.out.println(new Solution().strStr("1", "11"));
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int needleLength = needle.length();
        for (int i = 0, l = haystack.length() - needleLength; i <= l; i++) {
            String sub = haystack.substring(i, i + needleLength);
            for (int j = needleLength - 1; j >= 0; j--) {
                if (sub.charAt(j) != needle.charAt(j)) {
                    int k = j;
                    while (k > 0) {
                        k --;
                        if (sub.charAt(k) == needle.charAt(k)) {
                            i += (needleLength - 1 - k);
                            break;
                        }
                    }
                    break;
                }
                if (j == 0) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int rk(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int needleHashCode = 0;
        for (char c : needle.toCharArray()) {
            needleHashCode += hash(c);
        }

        int needleLength = needle.length();
        int subStrHashCode = 0;
        int hashIdx = 0;
        for (int i = 0, l = haystack.length() - needleLength; i <= l; i++) {
            while (hashIdx < i + needleLength) {
                if (i > 0) {
                    subStrHashCode -= hash(haystack.charAt(i - 1));
                }
                subStrHashCode += hash(haystack.charAt(hashIdx));
                hashIdx ++;
            }

            if (subStrHashCode != needleHashCode) {
                continue;
            }

            if (Objects.equals(haystack.substring(i, i + needleLength), needle)) {
                return i;
            }
        }

        return -1;
    }

    private static int hash(char c) {
        return (int) c;
    }

}
