package com.structures.linkedlist;

/**
 * @Author Agony
 * @Create 2023/3/20 11:07
 * @Version 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        // HeroNode hero3_1 = new HeroNode(3, "吴用", "智多星~");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // doubleLinkedList.add(hero1);
        // doubleLinkedList.add(hero2);
        // doubleLinkedList.add(hero3);
        // doubleLinkedList.add(hero4);

        // doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.showList();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 添加链表
    public void add(HeroNode2 node) {
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    // 通过 no 的顺序添加
    public void addByOrder(HeroNode2 node) {
        HeroNode2 temp = head;
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
            node.pre = temp;
            node.next = temp.next;
            temp.next = node;
            if (node.next != null) {
                node.next.pre = node;
            }

        } else {
            System.out.println("节点已存在");
        }
    }

    // 修改节点
    public void update(HeroNode2 node) {
        HeroNode2 temp = head.next;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 是否找到该节点
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号为 %d 的节点", node.no);
        }
    }

    // 删除节点
    public void delete(int no) {

        HeroNode2 temp = head.next;
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;

            // 如果是最后一个节点需要判断，否则会出现空指针异常
            if (temp.next != null)
                temp.next.pre = temp.pre;
        } else {
            System.out.println("没有找到该节点");
        }
    }

    // 显示链表
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2[" + "no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}