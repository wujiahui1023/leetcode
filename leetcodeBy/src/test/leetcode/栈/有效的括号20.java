package test.leetcode.栈;

import java.util.Stack;

/**
 * @author jiahui.wu
 */
public class 有效的括号20 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));

        System.out.println(solution.isValid("[()]{}"));

    }

    static class Solution {
        public boolean isValid(String s) {

            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<Character>();

            for (char c : chars) {

                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {

                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (c == '}' && stack.pop() != '{') {
                        return false;
                    }
                    if (c == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (c == ']' && stack.pop() != '[') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public boolean isValid1(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
