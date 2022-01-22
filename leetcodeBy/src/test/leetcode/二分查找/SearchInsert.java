package test.leetcode.二分查找;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/search-insert-position/
 * @author: wuJh
 * @create: 2022-01-22 13:15
 **/
public class SearchInsert {


    public static void main(String[] args) {

        System.out.println(3 / 2);

    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;

            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;

    }


}
