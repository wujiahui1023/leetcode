package LeetCode.leetcode.链表.面试题;

import common.ListNode;

/**
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/10/12 16:59
 */
public class 删除中间节点面试题0203 {

    /**
     * @param node
     */
    public void deleteNode(ListNode node) {

        //思路：将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点。
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
