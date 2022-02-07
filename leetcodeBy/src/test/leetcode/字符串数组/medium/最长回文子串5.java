package test.leetcode.字符串数组.medium;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 * @author: wuJh
 * @create: 2021-12-22 17:32
 **/
public class 最长回文子串5 {


    public static void main(String[] args) {



        int i = 111/10;
        System.out.println(i);
        int i1 = 111%10;
        System.out.println(i1);
    }


    public String demo1(String s) {

        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxlength = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxlength && valid(chars, i, j)) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }

    private boolean valid(char[] chars, int left, int right) {

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }


    public String demo2(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 枚举子串长度
        for (int L = 2; L < len; L++) {
            //左边界
            for (int i = 0; i < len; i++) {

                // 右边界
                int j = L + i - 1;
                if (j > len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }


            }
        }

        return "";
    }


}
