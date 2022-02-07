package LeetCode.leetcode.字符串数组.medium;

/**
 * 祈王殿下
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/12/5 16:27
 */
public class 无重复字符的最长子串3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abacfdeaf"));



    }


    /**
     * 通常涉及到 子串问题 -> 往往可以用 -> 滑动窗口
     * 该题采用 双指针解法 -> https://www.bilibili.com/video/BV15J411V7y4
     *
     * @param s
     * @return
     */
    static int lengthOfLongestSubstring(String s) {

        int[] count = new int[128];
        int i = 0;
        int j = 0;
        int result = 0;

        while (j < s.length()) {

            int c = s.charAt(j) - ' ';
            while (count[c] > 0) {

                count[s.charAt(i) - ' ']--;
                i++;
            }

            count[c]++;
            j++;

            result = Math.max(result, j - i);

        }
        return result;
    }


}
