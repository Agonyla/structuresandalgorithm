package com.structures.sparsearray;

/**
 * @Author Agony
 * @Create 2023/3/16 18:43
 * @Version 1.0
 * 稀疏数组的使用
 */
public class SparseArray {

    public static void main(String[] args) {

        // 创建一个原始的二维数组， 11 * 11
        // 0：表示没有棋子  1：表示黑子  2：表示蓝子
        int row = 11;
        int col = 11;
        int[][] arr = new int[row][col];

        // 初始化黑子和蓝子
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[5][9] = 1;

        // 遍历数组得到有效个数
        System.out.println("原始数组为===================");
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        // System.out.println(sum);

        System.out.println("=================================");
        // 原始数组转稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        // 初始化稀疏数组
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;
        // count 用来统计是第几个非零数据
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组
        System.out.println("稀疏数组为==================================");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        // 稀疏数组转原始数组
        int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 遍历稀疏数组获取有效值
        for (int i = 1; i < sparseArr.length; i++) {
            newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("原始数组============================");

        for (int[] ints : newArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
