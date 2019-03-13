package a4_median_of_two_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Median of Two Sorted Arrays
 *
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/11 22:12
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class Solution {

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int mid = (m + n) / 2 + 1;
        int idx = 0;
        int cursor1 = 0;
        int cursor2 = 0;

        List<Integer> list = new ArrayList<>(mid);

        int num1 = nums1[cursor1];
        int num2 = nums2[cursor2];

        list.add(Math.min(num1, num2));
        idx ++;

        while (idx < mid) {
            idx ++;
            if (cursor1 + 1 >= m) {
                cursor2 ++;
                num2 = nums2[cursor2];
                list.add(num2);
            } else if (cursor2 + 1 >= n) {
                cursor1 ++;
                num1 = nums1[cursor1];
                list.add(num1);
            } else if (num1 < num2) {
                cursor1 ++;
                num1 = nums1[cursor1];
                list.add(Math.min(num1, num2));
            } else {
                cursor2 ++;
                num2 = nums2[cursor2];
                list.add(Math.min(num1, num2));
            }
        }

        System.out.println(idx);
        System.out.println(list);

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] arr1 = {1,3, 5, 7, 9};
//        int[] arr2 = {2};

        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }

}
