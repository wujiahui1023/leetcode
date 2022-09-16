package common;

/**
 * @author jiahui.wu
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public TreeNode() {
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }


    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        left.left = left1;
        left.right = right2;

        int len = maxDepth(root);
        System.out.println(len);

    }
}
