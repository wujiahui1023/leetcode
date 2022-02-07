package LeetCode.leetcode.数组.medium;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/container-with-most-water/
 * @author: wuJh
 * @create: 2021-12-21 17:24
 **/
public class 盛最多水的容器11 {

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int area = Math.min(height[l], height[r]) * (r - l);

        while (l < r) {
            if (height[l] < height[r]) {

                ++l;
                area = Math.max(area, Math.min(height[l], height[r]) * (r - l));

            }else {

                r--;
                area = Math.max(area, Math.min(height[l], height[r]) * (r - l));

            }

        }
        return area;

    }


}
