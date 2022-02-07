package LeetCode.leetcode.字符串数组.medium;

/**
 * @program: leetcodeBy
 * @description: https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 * @author: wuJh
 * @create: 2021-12-14 17:01
 **/
public class 跳跃数组 {


    public static void main(String[] args) {

        String s = "香港特别行政区";
        String a = "香港";

        if(s.contains(a)){

            System.out.println(11);

        }

    }

    private Boolean demo(int[] array) {

        int size = array.length;
        int reach = 0;
        for (int i = 0; i < size; i++) {
            if (i > reach) {
                return false;
            }

            reach = Math.max(i + array[i], reach);
        }
        return true;
    }

    /***********************************************************************************************/


}
