package com.yy.example.data_structure_and_algorithm.again_20221026.ds.linklist.leetcode.topic_1_1_array;

import java.util.Arrays;

/**
 * Description: 旋转矩阵
 * <pre>
 *  给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *  不占用额外内存空间能否做到？
 *
 *  示例 1:
 *  给定 matrix =
 *  [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 *  ],
 *
 *  原地旋转输入矩阵，使其变为:
 *  [
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 *  ]
 *  链接：
 *  https://leetcode.cn/leetbook/read/array-and-string/clpgd/
 *  https://leetcode.cn/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 10/26/22 at 9:55 AM
 */
public class LC4_RotateMatrix {

    /**
     * 使用辅助数组，即新建一个辅助数组
     * 1 2 3            o o 1
     * o o o  旋转90度后 o o 2
     * o o o            o o 3
     * 第一行的第一列 --> 倒数第一列的第一行
     * 第一行的第二列 --> 倒数第一列的第二行
     * 第一行的第三列 --> 倒数第一列的第三行
     * 所以，推倒出公式：arr[row][col] -> arr[col][n - row - 1]
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] matrix_new = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix_new[j][size - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     * 旋转90度 = 先水平翻转 + 对角线翻转
     * 水平翻转的公式 ： arr[row][col] => arr[n - row - 1][col] => 行变列不变
     * 对角线反转的公式：arr[row][col] => arr[col]row]          => 行列互换
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int size = matrix.length;
        // 先水平翻转
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int temp = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // 再对角线翻转
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        LC4_RotateMatrix rotate = new LC4_RotateMatrix();
        rotate.rotate2(matrix);
        Arrays.stream(matrix).forEach(a -> System.out.println(a[0] + "," + a[1] + "," + a[2]));
    }
}
