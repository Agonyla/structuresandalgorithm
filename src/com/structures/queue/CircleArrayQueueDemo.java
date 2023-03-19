package com.structures.queue;

import java.util.Scanner;

/**
 * @Author Agony
 * @Create 2023/3/19 16:10
 * @Version 1.0
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("\ns(show):\t显示队列");
            System.out.println("e(exit):\t退出程序");
            System.out.println("a(add):\t\t添加数据到队列");
            System.out.println("g(get):\t\t从队列取出数据");
            System.out.println("h(head):\t查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        rear = 0;
        front = 0;
        arr = new int[this.maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断数组是否满了
        if (isFull()) {
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断数组是否为空
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    // 显示队列的所有数据
    public void showQueue() {
        // 判断数组是否为空
        if (isEmpty()) {
            System.out.println("数组为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 显示队列有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        return arr[front];
    }
}
