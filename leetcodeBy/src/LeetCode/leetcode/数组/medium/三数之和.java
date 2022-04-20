package LeetCode.leetcode.数组.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
 * @author: wuJh
 * @create: 2022-04-18 15:35
 **/
public class 三数之和 {


    /**
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     * <p>
     * 算法流程：
     * 特判，对于数组长度 nn，如果数组为 null 或者数组长度小于 33，返回 []。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
     * 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
     * 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
     * 复杂度分析
     * 时间复杂度：O\left(n^{2}\right)O(n
     * 2
     * )，数组排序 O(N \log N)O(NlogN)，遍历数组 O\left(n\right)O(n)，双指针遍历 O\left(n\right)O(n)，总体 O(N \log N)+O\left(n\right)*O\left(n\right)O(NlogN)+O(n)∗O(n)，O\left(n^{2}\right)O(n
     * 2
     * )
     * 空间复杂度：O(1)O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
