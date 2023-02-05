package p_067_add_binary;

import java.util.Objects;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * @author BaoXuebin
 * @since 2021/12/29
 */
public class Solution {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }
        String result = "";
        int l = 0;
        while (l < a.length()) {
            int intA = Integer.parseInt(a.substring(Math.max(0, a.length() - 1 - l), a.length() - l), 2);
            int intB = 0;
            if (b.length() > l) {
                intB = Integer.parseInt(b.substring(Math.max(0, b.length() - 1 - l), b.length() - l), 2);
            }
            result = Integer.toBinaryString(intA + intB) + result;
            l += 1;
        }
        return result;
    }

    private static boolean assertTrue(String a, String b, String result) {
        return Objects.equals(new Solution().addBinary(a, b), result);
    }

    public static void main(String[] args) {
        System.out.println(Solution.assertTrue("101111", "10", "110001"));
//        System.out.println(Solution.assertTrue("11", "1", "100"));
//        System.out.println(Solution.assertTrue("0", "0", "0"));
//        System.out.println(Solution.assertTrue("1", "1", "10"));
//        System.out.println(Solution.assertTrue("1011000110101001000100111010001100011000001001100100111110111011110001001101101", "1011000110101001000100111010001100011000001001100100111110111011110001001101101", "1011000110101001000100111010001100011000001001100100111110111011110001001101101"));
    }

}
