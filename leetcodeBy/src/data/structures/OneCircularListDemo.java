package data.structures;


/**
 * 单向环形链表(约瑟夫环)
 *
 * @author jiahui.wu
 */
public class OneCircularListDemo {

    public static void main(String[] args) {
        OneCircularList circularList = new OneCircularList();
        circularList.add(10);
        circularList.list();

    }

}

// 构建一个单向环形链表思路：
// 1 先构建第一个节点，让first 指向该节点，并形成环
// 2 后面每新增的节点，添加即刻

// 遍历单向环形链表思路
// 1 先让一个辅助指针变量cur，指向first 节点
// 2 然后 while循环  cur = cur.next ，直到 cur.next == first 结束
class OneCircularList {

    BoyNode first = new BoyNode(0);

    // node 约瑟夫 移除



    // 添加 num 个 节点
    public void add(int num) {

        if (num < 1) {
            return;
        }
        BoyNode cur = null;
        for (int i = 1; i <= num; i++) {

            if (i == 1) {
                first = new BoyNode(i);
                first.next = first;
                cur = first;
            } else {

                BoyNode node = new BoyNode(i);
                cur.next = node;
                node.next = first;
                cur = node;

            }
        }
    }

    public void list() {

        if (first == null || first.next == null) {
            return;
        }

        BoyNode cur = first;
        while (true) {

            System.out.println(cur.no);
            if (cur.next == first) {
                break;
            }
            cur = cur.next;

        }


    }
}

class BoyNode {

    public int no;

    public BoyNode next;

    BoyNode(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}


