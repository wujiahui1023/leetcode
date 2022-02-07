package LeetCode.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author jiahui.wu
 */

public class ReverseList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode newNode = null;
        while (head != null){

            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }


}
