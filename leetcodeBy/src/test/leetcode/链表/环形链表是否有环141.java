package test.leetcode.链表;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/9 14:25
 */
public class 环形链表是否有环141 {

    /**
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {

            if (fast == null || fast.next == null) {
                return false;
            }


            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public boolean hasCycleMap(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


}
