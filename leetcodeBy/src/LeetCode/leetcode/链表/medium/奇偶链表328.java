package LeetCode.leetcode.链表.medium;

import common.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/11/13 10:34
 */
public class 奇偶链表328 {

    /**
     * 链表问题 -> 双指针大多数都能解决
     *
     * <p>
     * 结点1作为奇数链的头 结点2作为偶数链的头
     * 从第3个点开始遍历，依次轮流附在奇、偶链的后面
     * 遍历完后，奇数链的尾连向偶链的头，偶链的尾为空， 返回奇数链的头
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点   1o->2e->3->4->5->NULL
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        // 前奇数后偶数
        o.next = p;
        return head;
    }


}
