package LeetCode.leetcode.二叉树;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu-2/
 *
 * @author jiahui.wu
 */
public class 树前中后 {

    public static void main(String[] args) {


        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.left = node1;
        node.right = node2;
        List<Integer> res = new ArrayList<>();
        recursionPostorderTraversal(node, res);
        System.out.println(res);
    }


    public static void recursionPostorderTraversal(TreeNode root, List<Integer> res) {

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //go left down to the ground
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            //if we reach to the leaf, go back to the parent right, and repeat the go left down.
            TreeNode cur = stack.pop();
            root = cur.right;
            System.out.println(root);
        }

    }

    // -----------------------------------------------------

    //对比代码， 前序遍历，唯一区别就是， 一个一直向左， 一个一直向右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            //go left down to the ground
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            //if we reach to the leaf, go back to the parent right, and repeat the go left down.
            TreeNode cur = stack.pop();
            root = cur.right;
        }

        return res;
    }


    /**
     * 前序 -> 递归
     * @param root
     * @return
     */
    public List<Integer> diGui(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    //==================================中序===============================================

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // =================================后序=================================================

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            TreeNode cur = stack.pop();
            root = cur.left;
        }

        Collections.reverse(res);
        return res;
    }

}