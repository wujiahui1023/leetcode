package LeetCode.leetcode.数组.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/28 14:38
 */
public class 独一无二的出现次数1207 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        uniqueOccurrences(arr);
    }


    /**
     * 先计算每个数出现的次数，再存放到集合set中，判断长度
     * <p>
     * <p>
     * 第一步都是要先计算每个数出现的次数。后面的只需要判断这个出现次数的数组中元素是否有重复的。
     * <p>
     * 我们知道集合set是不能有重复元素的，如果有就会替换掉，
     * 我们可以把出现次数的数组放到集合set中，如果有重复的就会被替换掉，
     * 那么set的大小肯定和出现次数的数组长度不一样。否则如果没有重复的，他们的长度肯定是一样的
     *
     * @param arr
     * @return
     */
    static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            Integer s = map.getOrDefault(arr[i], 0);
            map.put(arr[i], s + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }

    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }


}
