package LeetCode.leetcode.数组.simple;

/**
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 */
public class 有效的山脉数组941 {


    /**
     * 数组问题优先考虑 -> 双指针
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {

        int len = A.length;
        int left = 0;
        int right = len - 1;

        //从左边往右边找，一直找到山峰为止
        while (left + 1 < len && A[left] < A[left + 1]) {
            left++;
        }
        //从右边往左边找，一直找到山峰为止
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }


    public boolean validMountainArray1(int[] A) {


        if (A.length < 3) {
            return false;
        }
        int peakCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            // 平地
            if (A[i - 1] == A[i]) {
                return false;
            }
            // 山谷
            if (A[i - 1] > A[i] && A[i] < A[i + 1]) {
                return false;
            }
            // 山峰
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peakCount++;
            }
        }
        // 有且只有 1 个山峰
        return peakCount == 1;
    }


}
