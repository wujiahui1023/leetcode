package test.leetcode.字符串数组.simple;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/search-insert-position/
 * @author: wuJh
 * @create: 2021-11-22 19:44
 **/
public class 搜索插入位置35 {

    public int searchInsert(int[] num, int target) {

        int n = num.length;
        int left = 0;
        int right = n - 1;
        int ans = n;

        while (left <= right) {

            int mid = ((right - left) >> 1) + left;
            if (target <= num[mid]) {
                ans = num[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
