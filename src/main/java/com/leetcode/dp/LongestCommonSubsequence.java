package main.java.com.leetcode.dp;

import java.util.Arrays;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {

    int[][] memo;
    int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }


    int dp(String s1, int i, String s2, int j) {
        if (i== s1.length() || j == s2.length()) return 0;
        if (memo[i][j]!=-1)return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = 1+ dp(s1,i+1,s2,j+1);
        }else {
            memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
