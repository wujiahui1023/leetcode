package LeetCode.leetcode.二叉树.medium;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/11/24 14:51
 */
public class 完全二叉树的节点个数222 {


    /**
     * 前中后 深度广度 都能做
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res.size();
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
