package LeetCode.leetcode;

/**
 * 翻转二叉树
 *
 * @author jiahui.wu
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode invertTree(TreeNode root) {


        if(root ==null ){
            return null;
        }

        // 保存右子树
        TreeNode rightTree = root.right;

        root.right = invertTree(root.left);

        root.left = invertTree(rightTree);
        return root;
    }


}
