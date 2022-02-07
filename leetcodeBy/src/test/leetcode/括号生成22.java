package test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * @author: wuJh
 * @create: 2021-11-17 20:29
 **/
public class 括号生成22 {

    public static void main(String[] args) {

        List<String> strings = generateParenthesis(4);
        System.out.println(generateParenthesis(strings.size()));
    }


    /**
     * 做减法
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();

        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }


    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {

        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }


}
