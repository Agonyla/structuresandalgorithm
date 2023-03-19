package com.structures.linkedlist;

import java.util.Stack;

/**
 * @Author Agony
 * @Create 2023/3/19 18:00
 * @Version 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        // HeroNode hero3_1 = new HeroNode(3, "吴用", "智多星~");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // HeroNode hero4_1 = new HeroNode(4, "林冲", "豹子头~");


        // System.out.println(hero1);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        // singleLinkedList.addByOrder(hero1);
        // singleLinkedList.addByOrder(hero3);
        // singleLinkedList.addByOrder(hero2);
        // singleLinkedList.addByOrder(hero4);
        singleLinkedList.showList();
        System.out.println("================");
        // singleLinkedList.update(hero4_1);
        // singleLinkedList.update(hero3_1);
        // singleLinkedList.showList();
        // singleLinkedList.delete(3);
        // singleLinkedList.showList();

        // System.out.println(getLength(singleLinkedList.getHead()));

        // HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 3);
        // System.out.println(lastIndexNode);
        // reverseList2(singleLinkedList.getHead());
        // singleLinkedList.showList();
        reversePrint(singleLinkedList.getHead());

    }

    // 求单链表有效节点个数
    public static int getLength(HeroNode head) {

        int count = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 查找链表倒数第k个元素
    public static HeroNode findLastIndexNode(HeroNode head, int index) {

        HeroNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空");
            return null;
        }

        int length = getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }
        for (int i = 0; i < length - index + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 单链表反转   原地反转
    public static void reverseList(HeroNode head) {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = temp.next;
        while (true) {
            if (next == null) {
                break;
            }
            temp.next = next.next;
            next.next = head.next;
            head.next = next;
            next = temp.next;
        }
    }

    // 链表反转  头插法
    public static void reverseList2(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (true) {
            if (temp == null) {
                break;
            }
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;

        }
        head.next = reverseHead.next;
    }

    // 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head) {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        // 取出打印
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }
}

// 管理我们的英雄
class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    // 添加链表
    public void add(HeroNode node) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    // 通过 no 的顺序添加
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            // 遍历到末尾直接退出
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {

                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("节点已存在");
        }
    }

    // 修改节点
    public void update(HeroNode node) {
        HeroNode temp = head;
        // 是否找到该节点
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = node.name;
            temp.next.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号为 %d 的节点", node.no);
        }
    }

    // 删除节点
    public void delete(int no) {

        // temp 指向头节点
        HeroNode temp = head;
        boolean flag = false;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该节点");
        }
    }

    // 显示链表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

}

class HeroNode {

    public int no;
    public String name;
    public String nickName;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode[" + "no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }
}