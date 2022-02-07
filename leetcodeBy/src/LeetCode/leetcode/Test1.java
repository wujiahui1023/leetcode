package LeetCode.leetcode;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
 *
 * @author jiahui.wu
 */
public class Test1 {


    public static void main(String[] args) {

        int a1 = 9/2;
                System.out.println(a1);

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 7, 8};
        int a = missingNumber(nums);
        System.out.println(a);
    }

    public static int missingNumber(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        return left;
    }

}
