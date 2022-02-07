package LeetCode.leetcode.链表;

import common.ListNode;


/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/21 15:40
 */
public class 反转链表206 {

    public static void main(String[] args) {

        ListNode root = new ListNode(0);

        ListNode root1 = new ListNode(1);
        root.next = root1;

        ListNode root2 = new ListNode(2);
        root1.next = root2;

        ListNode root3 = new ListNode(3);
        root2.next = root3;

        reverseList(root);
    }

    /**
     * 迭代 ->
     * 反转核心
     * curr.next = prev;
     * prev = curr;
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {

            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归
     * head.next.next = head;
     * head.next = null;
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
