package main.java.com.leetcode.dp;

public class LongestPalindrome {

    public static void main(String[] args) {
    }

    /**
     * leecode 5. 最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        int max = 0;
        int start = -1;
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (charArray[i] != charArray[j]) {
                    dp[j][i] = false;
                } else {
                    if (i - j <= 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j > max) {
                    max = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
