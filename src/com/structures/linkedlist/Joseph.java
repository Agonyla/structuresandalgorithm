package com.structures.linkedlist;

/**
 * @Author Agony
 * @Create 2023/3/20 20:24
 * @Version 1.0
 */
public class Joseph {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(8);
        circleSingleLinkedList.showList();
        circleSingleLinkedList.countBoy(2, 3, 8);
    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    /**
     * @param number 添加孩子的数量
     *               添加节点
     */
    public void add(int number) {

        Boy temp = null;
        if (number <= 0) {
            System.out.println("数量应该大于0");
            return;
        }

        for (int i = 1; i <= number; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                temp = first;
            } else {
                temp.next = boy;
                boy.next = first;
                temp = boy;
            }
        }
    }

    /**
     * 显示当前列表
     */
    public void showList() {
        Boy temp = first;
        while (temp.next != first) {
            System.out.print(temp.no + "->");
            temp = temp.next;
        }
        System.out.println(temp.no);
    }

    /**
     * @param startNo 开始数数的人
     * @param step    数几下
     * @param nums    圈中的人数
     *                孩子出圈
     */
    public void countBoy(int startNo, int step, int nums) {

        if (startNo <= 0 || step <= 0 || step >= nums) {
            System.out.println("输入的参数有误");
            return;
        }
        // 辅助变量，该变量应指向最后一个节点
        Boy helper = first;
        // 1.首先让helper指向最后一个节点
        while (helper.next != first) {
            helper = helper.next;
        }

        // 2.让helper 和 first 移动 startNo - 1 次, 使first落在 startNo 位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        System.out.print("出圈顺序为:");
        // 3.出圈  出圈结束条件  当 helper == first 时 只剩下一个人 游戏结束
        while (helper != first) {
            // 让helper 和 first 移动 step - 1 次, 让first落在要出圈人的位置上
            for (int i = 0; i < step - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.print(first.no + "->");
            first = first.next;
            helper.next = first;
        }
        System.out.println(first.no);

    }

}

class Boy {

    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }
}