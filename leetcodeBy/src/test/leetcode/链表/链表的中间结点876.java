package test.leetcode.链表;

import common.ListNode;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/21 14:51
 */
public class 链表的中间结点876 {

    /**
     * 单指针思路 -> 空间复杂度 O(1) 时间复杂度 O(N)
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 快慢指针思路  -> 空间复杂度 O(1) 时间复杂度 O(N)
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
