package LeetCode.leetcode.字符串数组.simple;

import java.util.*;

/**
 * @author https://github.com/wujiahui1023
 */
public class 字母异位词分组49 {


    /**
     * @param strs
     * @return
     */
    static List<List<String>> demo(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String string = new String(ca);
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str);
            map.put(string, list);
        }
        return new ArrayList<>(map.values());
    }
}
