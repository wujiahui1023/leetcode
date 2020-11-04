package test.leetcode.链表.medium;

import common.ListNode;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author https://github.com/wujiahui1023
 * @date 2020/11/4 16:07
 */
public class 两数相加445 {


    /**
     * 思路：
     * 链表能翻转
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //将两个链表反转
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);

        //累加的和是否有超过10进位的情况
        int carry = 0;

        ListNode after = null;
        while (newl1 != null || newl2 != null || carry != 0) {
            //反转后的链表取值并求和
            int n1 = newl1 == null ? 0 : newl1.val;
            int n2 = newl2 == null ? 0 : newl2.val;
            newl1 = newl1 == null ? newl1 : newl1.next;
            newl2 = newl2 == null ? newl2 : newl2.next;
            int sum = n1 + n2 + carry;

            //根据和求当前位置的值 和 进位的值 并连接上链表
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = after;
            after = tmp;
            carry = sum / 10;
        }
        return after;
    }

    /**
     * 将给定头结点的链表反转
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 思路：
     * 链表不能翻转 -> 栈
     * 遍历链表入栈，得到stack1和stack2。
     * 定义进位carry，和最终结果result。
     * stack1 和 stack2 执行出栈操作，直至栈顶为空。
     * 分别获取栈顶元素，默认值为0；
     * 栈顶元素和carry相加，判断是否有进位。有进位carry赋值为1，反之carry为0；
     * 创建新的节点，将新节点的next指向result（新节点为高位）
     * 则新节点为新的result
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {


        // 利用栈的先进后出原则实现加法
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 将链表数据入栈，栈顶为低位
        while ((l1 != null) || (l2 != null)) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        int num1 = 0;
        int num2 = 0;

        // 存储进位数据
        int carry = 0;

        // 最终结果
        ListNode result = null;

        // 出栈，出栈过程是计算相对低位数据的过程
        while (!stack1.empty() || !stack2.empty() || carry == 1) {
            num1 = stack1.empty() ? 0 : stack1.pop();
            num2 = stack2.empty() ? 0 : stack2.pop();
            ListNode listNode = new ListNode(0);

            // 有进位的情况
            if (num1 + num2 + carry > 9) {
                listNode.val = num1 + num2 + carry - 10;
                carry = 1;
            } else {
                // 无进位
                listNode.val = num1 + num2 + carry;
                carry = 0;
            }


            // -> 链表通用处理   listNode.next = result; result = listNode;
            // 原有高位降一位
            listNode.next = result;
            // 设置最新高位
            result = listNode;
        }

        return result;
    }


}
