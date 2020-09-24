package test.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * # 中序遍历 先遍历左子树->根节点->右子树
 * # 如果是递归做法则递归遍历左子树，访问根节点，递归遍历右子树
 * # 非递归过程即:先访问..最左子树..结点，再访问其父节点，再访问其兄弟
 * # while循环条件 中序遍历需先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
 * # 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
 * # Definition for a binary tree node.
 * # class TreeNode:
 * #     def __init__(self, x):
 * #         self.val = x
 * #         self.left = None
 * #         self.right = None
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author jiahui.wu
 */
public class InOrderTraversal {

    public static void main(String[] args) {

        TreeNode s0 = new TreeNode(0);
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

}
