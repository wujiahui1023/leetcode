package test.leetcode.链表.hard;

import common.ListNode;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/10 11:36
 */
public class 环形链表II142 {


    public ListNode test(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast) {

                ListNode pre = head;
                while (slow != pre) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
    }

    /**
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
