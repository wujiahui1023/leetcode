package test.leetcode.数组;

import java.text.MessageFormat;

public class 最长公共前缀14 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        solution.longestCommonPrefix(strs);

    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs.length < 1) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            int mien = Integer.MAX_VALUE;
            String result = "";
            for (String str : strs) {
                if (str.length() < mien) {

                    mien = str.length();
                    result = str;
                }
            }

            while (result.length() > 0) {
                Boolean flag = true;
                for (String str : strs) {
                    if (!str.substring(0, mien).equals(result)) {
                        mien--;
                        result = str.substring(0, mien);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(result);
                    return result;
               }
            }

            return result;

        }
    }

}
