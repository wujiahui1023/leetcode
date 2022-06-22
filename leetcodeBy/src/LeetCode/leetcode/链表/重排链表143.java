package LeetCode.leetcode.链表;

import common.ListNode;


/**
 * https://leetcode.cn/problems/reorder-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-143-z-4kmk/
 */
public class 重排链表143 {

    public void reorderList(ListNode head) {
        // a、寻找出原链表的中点，把链表划分为两个区域
        // b、将右边的链表进行反转
        // c、把这两个区域进行交错合并

        // 1、使用快慢指针寻找出链表的中点来
        // *******************************************************
        // 对于 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        // 中间节点值为 5
        // 所以左边区域为 1 -> 2 -> 3 -> 4 -> 5
        // 右边区域为 6 -> 7 -> 8
        // 但在视频讲解中，我把 5 归为了右边区域，这是一个错误
        // 虽然这个错误并不影响结果，因为合并过程都是一样的逻辑
        // *******************************************************
        ListNode mid = middleNode(head);

        // 2、基于 mid 这个中点，将链表划分为两个区域

        // 左边的区域开头节点是 head
        ListNode leftHead = head;

        // 右边的区域开头节点是 mid.next
        ListNode rightHead = mid.next;

        // 将链表断开，就形成了两个链表了
        mid.next = null;

        // 3、将右边的链表进行反转
        rightHead = reverseList(rightHead);

        // 4、将这两个链表进行合并操作，即进行【交错拼接】
        while (leftHead != null && rightHead != null) {

            // 拼接过程如下
            // 5、先记录左区域、右区域【接下来将有访问的两个节点】
            ListNode leftHeadNext = leftHead.next;

            ListNode rightHeadNext = rightHead.next;

            // 6、左边连接右边的开头
            leftHead.next = rightHead;

            // 7、leftHead 已经处理好，移动到下一个节点，即刚刚记录好的节点
            leftHead = leftHeadNext;

            // 8、右边连接左边的开头
            rightHead.next = leftHead;

            // 9、rightHead 已经处理好，移动到下一个节点，即刚刚记录好的节点
            rightHead = rightHeadNext;

        }

    }

    // LeetCode 876 : 链表的中间节点
    public ListNode middleNode(ListNode head) {

        ListNode fast = head;

        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            slow = slow.next;
        }

        return slow;

    }

    // LeetCode 206 : 反转链表
    public ListNode reverseList(ListNode head) {

        // 寻找递归终止条件
        // 1、head 指向的结点为 null
        // 2、head 指向的结点的下一个结点为 null
        // 在这两种情况下，反转之后的结果还是它自己本身
        if (head == null || head.next == null) return head;

        // 不断的通过递归调用，直到无法递归下去，递归的最小粒度是在最后一个节点
        // 因为到最后一个节点的时候，由于当前节点 head 的 next 节点是空，所以会直接返回 head
        ListNode cur = reverseList(head.next);

        // 比如原链表为 1 --> 2 --> 3 --> 4 --> 5
        // 第一次执行下面代码的时候，head 为 4，那么 head.next = 5
        // 那么 head.next.next 就是 5.next ，意思就是去设置 5 的下一个节点
        // 等号右侧为 head，意思就是设置 5 的下一个节点是 4

        // 这里出现了两个 next
        // 第一个 next 是「获取」 head 的下一节点
        // 第二个 next 是「设置」 当前节点的下一节点为等号右侧的值
        head.next.next = head;


        // head 原来的下一节点指向自己，所以 head 自己本身就不能再指向原来的下一节点了
        // 否则会发生无限循环
        head.next = null;

        // 我们把每次反转后的结果传递给上一层
        return cur;
    }

}
