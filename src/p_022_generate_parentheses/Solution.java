package p_022_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 提示：
 * 1 <= n <= 8
 *
 * @author BaoXuebin
 * @since 2023/2/5
 */
public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String resStr) {
        if (left == 0 && right == 0) {
            res.add(resStr);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, resStr + '(');
        }
        if (right > left) {
            dfs(left, right - 1, resStr + ')');
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(1));
//        System.out.println(solution.generateParenthesis(3));
    }

}
