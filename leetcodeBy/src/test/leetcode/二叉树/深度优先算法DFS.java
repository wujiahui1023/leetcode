package test.leetcode.二叉树;


import common.TreeNode;

import java.util.Stack;

/**
 * https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487028&idx=1&sn=e06a0cd5760e62890e60e43a279a472b&chksm=fb419d14cc36140257eb220aaeac182287b10c3cab5c803ebd54013ee3fc120d693067c2e960&scene=21#wechat_redirect
 *
 * @author jiahui.wu
 */
public class 深度优先算法DFS {

    public static void main(String[] args) {

        TreeNode A = new TreeNode(0);

        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(2);

        TreeNode D = new TreeNode(3);
        TreeNode F = new TreeNode(4);


        A.left = B;
        A.right = C;

        B.left = D;
        B.right = F;

        treeDFS(A);
    }


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

    //-----------------------------------------------------------------------
    // 深度遍历DFS -> 根左右
    public static void treeDFS2(TreeNode root) {
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

//---------------------------------------------------------------------------------------------
    /**
     * 递归的写法
     */
    public static void treeDFS1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        treeDFS1(root.left);
        treeDFS1(root.right);
    }
}
