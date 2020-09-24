package test.leetcode.二叉树;

import common.TreeNode;

import java.util.LinkedList;

/**
 * https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487028&idx=1&sn=e06a0cd5760e62890e60e43a279a472b&chksm=fb419d14cc36140257eb220aaeac182287b10c3cab5c803ebd54013ee3fc120d693067c2e960&scene=21#wechat_redirect
 *
 * @author jiahui.wu
 */
public class 广度优先算法BFS {

    // 非递归
    public static void levelOrder(TreeNode tree) {
        if (tree == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<>();
        //链表，这里我们可以把它看做队列
        list.add(tree);
        //相当于把数据加入到队列尾部
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            //poll方法相当于移除队列头部的元素
            System.out.println(node.val);
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
    }


    // 递归
    public static void levelOrder1(TreeNode tree) {
        int depth = depth(tree);
        for (int level = 0; level < depth; level++) {
            printLevel(tree, level);
        }
    }

    private static int depth(TreeNode tree) {
        if (tree == null)
            return 0;
        int leftDepth = depth(tree.left);
        int rightDepth = depth(tree.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    private static void printLevel(TreeNode tree, int level) {
        if (tree == null)
            return;
        if (level == 0) {
            System.out.print(" " + tree.val);
        } else {
            printLevel(tree.left, level - 1);
            printLevel(tree.right, level - 1);
        }
    }


}
