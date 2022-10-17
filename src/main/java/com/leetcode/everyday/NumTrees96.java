package com.leetcode.everyday;

import com.leetcode.binaryTree.TreeNode;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/22
 */
public class NumTrees96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n];
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                count += dp[i - 1] * dp[n - i];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
