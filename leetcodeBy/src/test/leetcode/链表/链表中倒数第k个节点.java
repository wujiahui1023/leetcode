package test.leetcode.链表;

import common.ListNode;

/**
 * @author https://github.com/wujiahui1023
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode root = new ListNode(0);

        root = head;

        ListNode slow = root;
        ListNode fast = root;

        // 快指针先走 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;

        }

        return slow;

    }
}
