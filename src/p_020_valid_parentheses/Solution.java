package p_020_valid_parentheses;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * @author BaoXuebin
 * @since 2021/7/17
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        ;
    }

    /**
     * 构建一个链表，按左括号进入，右括号匹配后出的规则遍历字符串
     */
    private boolean isValid(String s) {
        Stack<Character> rest = new Stack<>();
        for (char c : s.toCharArray()) {
            leftInRightOut(rest, c);
            if (rest.size() > s.length() / 2) {
                return false;
            }
        }
        return rest.size() == 0;
    }

    private void leftInRightOut(Stack<Character> rest, char c) {
        if (rest.size() == 0) {
            rest.push(c);
        } else {
            if (match(rest.peek(), c)) {
                rest.pop();
            } else {
                rest.push(c);
            }
        }
    }

    private boolean match(char left, char right) {
        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
    }

}
