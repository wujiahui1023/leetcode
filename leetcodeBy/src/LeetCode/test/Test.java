package LeetCode.test;

import common.Node;

/**
 * @author jiahui.wu
 */
public class Test {

    public static void main(String[] args) {

        Node root = new Node(0);

        Node root1 = new Node(1);
        root.next = root1;

        Node root2 = new Node(2);
        root1.next = root2;

        Node root3 = new Node(3);
        root2.next = root3;


        Node root4 = new Node(4);
        root3.next = root4;

        Node root5 = new Node(5);
        root4.next = root5;

        Node dummy = new Node(0);
        //pre表示访下一层节点的前一个节点
        Node pre = dummy;
        Node cur = root;

        while (true){

            pre.next = cur.next;
            //然后再更新pre
            cur = cur.next;
            System.out.println(pre);
        }


    }

    static class Solution {

        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            //cur可以把它看做是每一层的链表
            Node cur = root;
            while (cur != null) {
                //遍历当前层的时候，为了方便操作
                // 在下一层前面添加一个哑结点（注意这里是访问
                //当前层的节点，然后把下一层的节点串起来）
                Node dummy = new Node(0);
                //pre表示访下一层节点的前一个节点
                Node pre = dummy;
                //然后开始遍历当前层的链表
                while (cur != null) {
                    if (cur.left != null) {
                        //如果当前节点的左子节点不为空，就让pre节点
                        //的next指向他，也就是把它串起来
                        pre.next = cur.left;
                        //然后再更新pre
                        pre = pre.next;
                    }
                    //同理参照左子树
                    if (cur.right != null) {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                    //继续访问这一行的下一个节点
                    cur = cur.next;
                }
                //把下一层串联成一个链表之后，让他赋值给cur，
                //后续继续循环，直到cur为空为止
                cur = dummy.next;
            }
            return root;
        }

    }
}
