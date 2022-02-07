package LeetCode.leetcode.二叉树.medium;

import common.TreeNode;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/29 10:32
 */
public class 求根到叶子节点数字之和129 {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }


    /**
     * 深度优先搜索
     * 从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点对应的数字加到数字之和。
     * 如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。
     * <p>
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉树的节点个数。对每个节点访问一次。
     * <p>
     * 空间复杂度：O(n)O(n)，其中 nn 是二叉树的节点个数。
     * 空间复杂度主要取决于递归调用的栈空间，
     * 递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)O(n)。
     *
     * @param root
     * @param prevSum
     * @return
     */
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
