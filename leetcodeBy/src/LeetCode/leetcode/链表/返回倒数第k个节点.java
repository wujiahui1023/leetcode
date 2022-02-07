package LeetCode.leetcode.链表;

import common.ListNode;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/9 17:09
 */
public class 返回倒数第k个节点 {

    /**
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {

        ListNode root = new ListNode(0);
        root.next = head;

        // 2 个快慢指针
        ListNode slow = root;
        ListNode fast = root;

        // 快指针先走 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // 然后， 快慢指针一起走，直到快指针走到头
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next.val;




    }


}
