package test.leetcode.二叉树;


import common.TreeNode;

import java.util.Stack;

/**
 * @author jiahui.wu
 */
public class 深度优先算法DFS {


    public static void treeDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //    递归的写法
    public static void treeDFS1(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        treeDFS(root.left);
        treeDFS(root.right);
    }
}
