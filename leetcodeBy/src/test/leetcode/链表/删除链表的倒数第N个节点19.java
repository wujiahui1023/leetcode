package test.leetcode.链表;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;


public class 删除链表的倒数第N个节点19 {

    public static void main(String[] args) {

        ListNode s1 = new ListNode(1);

        ListNode s2 = new ListNode(2);
        s1.next = s2;

        ListNode s3 = new ListNode(3);
        s2.next = s3;

        ListNode s4 = new ListNode(4);
        s3.next = s4;

        ListNode s5 = new ListNode(5);
        s4.next = s5;

        ListNode s6 = new ListNode(6);
        s5.next = s6;

        ListNode s7 = new ListNode(7);
        s6.next = s7;

        Solution solution = new Solution();
        solution.removeNthFromEnd(s1, 4);

    }


    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode root = new ListNode(0);
            root.next = head;

            // 2 个快慢指针
            ListNode slow = root;
            ListNode fast = root;

            // 快指针先走 n 步
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            // 然后， 快慢指针一起走，直到快指针走到头
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 最后将 慢指针的next 指向下下个节点，这个时候 就把倒是第n个的节点剔除
            slow.next = slow.next.next;

            // 返回
            return root.next;
        }


        /**
         * 用斩实现
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd1(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<ListNode>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }
}
