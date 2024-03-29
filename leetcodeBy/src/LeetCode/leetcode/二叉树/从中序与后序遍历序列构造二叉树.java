package LeetCode.leetcode.二叉树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author jiahui.wu
 */
public class 从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        System.out.println(treeNode.toString());

    }

    static class Solution {
        int post_idx;
        int[] postorder;
        int[] inorder;
        Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        public TreeNode helper(int in_left, int in_right) {
            // 如果这里没有节点构造二叉树了，就结束
            if (in_left > in_right) {
                return null;
            }

            // 选择 post_idx 位置的元素作为当前子树根节点
            int root_val = postorder[post_idx];
            TreeNode root = new TreeNode(root_val);

            // 根据 root 所在位置分成左右两棵子树
            int index = idx_map.get(root_val);

            // 下标减一
            post_idx--;
            // 构造右子树
            root.right = helper(index + 1, in_right);
            // 构造左子树
            root.left = helper(in_left, index - 1);
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.inorder = inorder;
            // 从后序遍历的最后一个元素开始
            post_idx = postorder.length - 1;

            // 建立（元素，下标）键值对的哈希表
            int idx = 0;
            for (Integer val : inorder) {
                idx_map.put(val, idx++);
            }

            return helper(0, inorder.length - 1);
        }
    }


}
