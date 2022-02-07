package LeetCode.leetcode.数组.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 祈王殿下
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/12/6 14:54
 */
public class 杨辉三角118 {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
