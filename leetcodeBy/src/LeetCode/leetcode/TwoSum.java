package LeetCode.leetcode;

import java.util.*;

/**
 * 一个数组中，找到2个值相加等于给定的值
 * 返回满足条件的数组下标
 * <p>
 * leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 *
 * @author jiahui.wu
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] a = new int[]{};
        int[] array = {2, 4, 6, 8, 11};
        int sum = 10;

        int[] ar = twoSum(array, sum);
        System.out.println(ar);


    }

    static int[] twoSum(int[] array, int sum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            if (map.containsKey(sum - array[i])) {
                return new int[]{i, map.get(sum - array[i])};
            }
            map.put(array[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/

}
