package test.leetcode.二叉树;

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针117 {

    public static void main(String[] args) {

        Node root = new Node(0);

        Node root1 = new Node(1);
        Node root2 = new Node(2);


        Node root3 = new Node(3);
        Node root4 = new Node(4);

        Node root5 = new Node(5);
        Node root6 = new Node(6);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;

        Solution solution = new Solution();
        Node dump = solution.connect(root);

        System.out.println(dump);


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


        public Node connect1(Node root) {

            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                //每一层的数量
                int levelCount = queue.size();
                //前一个节点
                Node pre = null;
                for (int i = 0; i < levelCount; i++) {
                    //出队
                    Node node = queue.poll();
                    //如果pre为空就表示node节点是这一行的第一个，
                    //没有前一个节点指向他，否则就让前一个节点指向他
                    if (pre != null) {
                        pre.next = node;
                    }
                    //然后再让当前节点成为前一个节点
                    pre = node;
                    //左右子节点如果不为空就入队
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }

    }
}
