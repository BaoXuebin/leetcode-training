package a6_zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 *
 * @author ：BaoXuebin
 * @date ：Created in 2019/3/14 20:51
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */
public class Solution {

    private String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (numRows >= s.length()) return s;

        System.out.println(s);

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
//            System.out.println(row);
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("PAYPALISHIRING", 15));;
        // solution.convert("PAYPALISHIRING", 5);
    }

}
