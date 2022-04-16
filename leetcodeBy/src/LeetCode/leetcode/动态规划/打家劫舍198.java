package LeetCode.leetcode.动态规划;

/**
 * @program: leetcodeBy
 * @description: 打家劫舍
 * @author: wuJh
 * @create: 2022-02-07 20:04
 **/
public class 打家劫舍198 {


    public static void main(String[] args) {

    }


    /**
     * 动态规范
     * 1. 先考虑边界   num数组长度为 1或2
     * 2. 再考虑状态转移方程  dp[i] = Math.max(dp[i-1], dp[i-2]+num[i])
     *
     * @param nums
     * @return
     */
    public int demo1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    public int demo2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length-1];
    }


}
