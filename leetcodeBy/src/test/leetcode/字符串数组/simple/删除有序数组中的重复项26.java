package test.leetcode.字符串数组.simple;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author: wuJh
 * @create: 2021-12-16 19:29
 **/
public class 删除有序数组中的重复项26 {


    /**
     * 快、慢指针 数组一般是快慢指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {

            return 1;
        }

        int length = nums.length;

        int slow = 1;
        int fast = 1;

        while (fast < length) {

            if (nums[fast - 1] != nums[fast]) {

                nums[slow] = nums[fast];
                slow++;

            }
            fast++;
        }
        return slow;
    }
}
