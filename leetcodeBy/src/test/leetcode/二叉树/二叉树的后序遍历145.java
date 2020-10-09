package test.leetcode.二叉树;

import common.Node;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiahui.wu
 */
public class 二叉树的后序遍历145 {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.right = node1;
        node1.left = node2;
        List<Integer> res = new ArrayList<>();
        recursionPostorderTraversal(node, res);
        System.out.println(res);
    }


    public static void recursionPostorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            recursionPostorderTraversal(root.left, res);
            recursionPostorderTraversal(root.right, res);
            System.out.print(root.val + " ");
            res.add(root.val);
        }
    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            postorder(root, res);
            return res;
        }

        public void postorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }


}
