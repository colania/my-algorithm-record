package com.leetcode.dp;

import java.util.Arrays;

public class MinFallingPathSum {

    int[][] memo;

    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            // 返回一个特殊值
            return 99999;
        }
        if (i == 0) {
            return matrix[i][j];
        }
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 状态转移
        return matrix[i][j] + min(
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j + 1)
        );


    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
