package test.leetcode.链表;

import common.ListNode;

/**
 * @program: github@wjh
 * @description: https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
 * @author: wuJh
 * @create: 2021-11-07 19:03
 **/
public class 反转链表92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 1. 从虚拟头节点 走到 left-1 步，到达 left节点 前一个位置
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 2. 从 pre 再走 right-left+1 步，来到 right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 截取子链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        return pre;

    }
}
