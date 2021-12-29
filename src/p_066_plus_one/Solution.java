package p_066_plus_one;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 66. Plus One
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 *
 * @author BaoXuebin
 * @since 2021/12/29
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            // equal 10
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    private static void print(int[] digits) {
        for (int i : digits) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        print(new Solution().plusOne(digits));
        int[] digits2 = {4, 3, 2, 1};
        print(new Solution().plusOne(digits2));
        int[] digits3 = {9};
        print(new Solution().plusOne(digits3));
    }

}
