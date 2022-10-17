package com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/26
 */
public class IsInterleave97 {
    public static void main(String[] args) {
        System.out.println(isInterleave("db", "b", "cbb"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1 && s1.charAt(i-1) == s3.charAt(i-1); i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n2 && s2.charAt(j-1) == s3.charAt(j-1); j++) dp[0][j] = true; // 不相符直接终止

        dp[0][0] = true;
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n1][n2];
    }
}
