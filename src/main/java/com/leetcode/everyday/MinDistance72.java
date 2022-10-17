package com.leetcode.everyday;

import java.util.Map;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/13
 */
public class MinDistance72 {

    public static void main(String[] args) {
        minDistance("","a");
    }

    public static int minDistance(String word1, String word2) {
        int w1len = word1.length();
        int w2len = word2.length();
        int dp[][] = new int[w1len + 1][w2len + 1];
        for (int i = 0; i <= w1len; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2len; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1len; i++) {
            for (int j = 1; j <= w2len; j++) {
               if (word1.charAt(i-1)  == word2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1];
               }else {
                   int min = Math.min(dp[i - 1][j - 1], dp[i][j - 1]);
                   min = Math.min(min, dp[i - 1][j]);
                   dp[i][j] = min + 1;
               }

            }
        }

        return dp[w1len][w2len];

    }
}
