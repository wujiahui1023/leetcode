package LeetCode.leetcode.二叉树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/er-cha-shu-zhong-xu-bian-li-de-liang-chong-fang-sh/
 *
 * @author jiahui.wu
 */
public class 二叉树查众树 {



    public void main1(String[] args) {

        TreeNode A = new TreeNode(0);

        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(2);

        TreeNode D = new TreeNode(3);
        TreeNode F = new TreeNode(4);


        A.left = B;
        A.right = C;

        B.left = D;
        B.right = F;

        findMode(A);
    }


    List<Integer> mList = new ArrayList<>();

    //表示当前节点的值
    private int current = 0;
    //表示当前节点的数量
    int count = 0;
    //最大的重复数量
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    //递归方式
    public void inOrderTraversal(TreeNode node) {
        //终止条件判断
        if (node == null) {
            return;
        }
        //遍历左子树
        inOrderTraversal(node.left);

        //下面是对当前节点的一些逻辑操作
        int nodeValue = node.val;
        if (nodeValue == current) {
            //如果节点值等于curent，count就加1
            count++;
        } else {
            //否则，就表示遇到了一个新的值，curent和count都要
            //重新赋值
            current = nodeValue;
            count = 1;
        }
        if (count == maxCount) {
            //如果count == maxCount，就把当前节点加入到集合中
            mList.add(nodeValue);
        } else if (count > maxCount) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后
            //把当前节点的值加入到集合中
            mList.clear();
            mList.add(nodeValue);
            maxCount = count;
        }

        //遍历右子树
        inOrderTraversal(node.right);
    }


}
