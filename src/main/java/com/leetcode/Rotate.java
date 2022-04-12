package main.java.com.leetcode;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/2
 */
public class Rotate {

    public static void main(String[] args) {

    }

    public static void rotate(int[][] matrix) {
        int tmp = 0;
        int[][] matrixNew = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixNew[j][matrix.length - i + 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = matrixNew[i][j];
            }
        }

    }
}
