package LeetCode.leetcode;

import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次(去重)。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1:
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiahui.wu
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {

        boolean[] booleans = new boolean[3];

        String abc = removeDuplicateLetters("bcabc");
        System.out.println(abc);
    }


    public static String removeDuplicateLetters(String s) {


        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
//        int[] count = new int[256];
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            count[c]++;
//        }

        Stack<Character> stack = new Stack<>();
        boolean[] booleans = new boolean[256];

        for (char c : s.toCharArray()) {

            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (booleans[c]) {
                // 已存在
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {

                // 若字符串以后不存在  stack.peek() 元素，则 停止pop
                if (count[stack.peek()] == 0) {
                    break;
                }
                booleans[stack.pop()] = false;
            }

            stack.push(c);
            booleans[c] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();

    }
}
