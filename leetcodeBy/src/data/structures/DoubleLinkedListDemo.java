package data.structures;

/**
 * 双向链表
 *
 * @author jiahui.wu
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        // 先创建节点
        HeroNode hero1 = new HeroNode(null, null, "宋江", 1);
        HeroNode hero2 = new HeroNode(null, null, "卢俊义", 2);
        HeroNode hero3 = new HeroNode(null, null, "吴用", 3);
        HeroNode hero4 = new HeroNode(null, null, "林冲", 4);

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        linkedList.list();


        // 修改
        HeroNode newHeroNode = new HeroNode(null, null, "公孙胜", 4);
        linkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        linkedList.list();

        System.out.println("删除后的链表情况");
        linkedList.delete(hero3);
        linkedList.list();

    }
}

class DoubleLinkedList {

    private HeroNode head = new HeroNode(null, null, "", 0);

    void delete(HeroNode heroNode) {

        HeroNode tempNode = head.next;

        while (true) {


            if (tempNode == null) {
                break;
            }
            if (heroNode.no == tempNode.no) {

                // 如果是删除中间的节点
                if (tempNode.next != null) {

                    tempNode.pre.next = tempNode.next;
                    tempNode.next.pre = tempNode.pre;
                    break;
                } else {
                    // 当删除的节点刚好是最后一个节点
                    tempNode.pre.next = tempNode.next;

                }
            }

            tempNode = tempNode.next;
        }
    }

    void update(HeroNode heroNode) {

        HeroNode tempNode = head;

        while (true) {

            if (tempNode.next == null) {
                return;
            }
            if (tempNode.next.no == heroNode.no) {
                tempNode.next.name = heroNode.name;
                break;
            }
            tempNode = tempNode.next;
        }
    }

    public void add(HeroNode heroNode) {

        HeroNode tempNode = head;

        while (true) {
            if (tempNode.next == null) {
                tempNode.next = heroNode;
                heroNode.pre = tempNode;
                break;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    public void list() {

        HeroNode tempNode = head.next;
        while (true) {

            if (tempNode == null) {
                break;
            }
            System.out.println(tempNode.name);
            tempNode = tempNode.next;
        }
    }


    public HeroNode getHead() {
        return head;
    }
}


class HeroNode {

    public HeroNode pre;
    public HeroNode next;
    public String name;
    public int no;


    HeroNode(HeroNode pre, HeroNode next, String name, int no) {
        this.pre = pre;
        this.next = next;
        this.name = name;
        this.no = no;
    }


    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}



